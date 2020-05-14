#include <LiquidCrystal.h>

// initialize the library with the numbers of the interface pins
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

//DEFINE OUTPUT PINS
#define PORT_LCD PORTB
#define BIT_LCD13 5
#define BIT_LCD12 4
#define BIT_LCD11 3
#define BIT_LCD10 2
#define BIT_LCD9 1
#define BIT_LCD8 0

#define PORT_LED PORTD
#define BIT_LED_YELLOW 7
#define BIT_LED_GREEN 6

//DEFINE INPUT PINS
#define PORT_BUTTON PORTD
#define PIN_BUTTON PIND
#define BIT_BUTTON_BLUE 4
#define BIT_BUTTON_YELLOW 3
#define BIT_BUTTON_GREEN 2

#define PORT_ANALOG PORTC
#define PIN_ANA PINC
#define BIT_BRIGHT A0

// MAIN EVENT FLAG
volatile int mainEventFlags = 0;
#define FLAG_YELLOW 0x01
#define FLAG_GREEN 0x02

//BLUE STATE
uint8_t blueState = 1;
uint8_t lastBlueState = 1;

// TRACK PORTD CHANGE
volatile uint8_t portdhistory = 0xFF;

//USING 16 MHZ CLOCK DO 0.1 SECOND INTERRUPTS
//TIMER 1 YELLOW COUNTER
//COUNTER AND COMPARE VALUES
#define TIMER_1_START 0
#define TIMER_1_COMPARE 25000
//TIMER 2 GREEN COUNTER (USE 0.001 SECOND INTERRUPTS)
//COUNTER AND COMPARE VALUES
#define TIMER_2_START 0
#define TIMER_2_COMPARE 250

unsigned long delayTimerTS = 0;
uint8_t isDelayRunning = 0;

unsigned long yellowTimerTS = 0;
uint8_t isYellowRunning = 0;
unsigned long greenTimerTS = 0;
uint8_t isGreenRunning = 0;

void setup()
{
    // SET OUTPUTS
    DDRB |= _BV(BIT_LCD13) | _BV(BIT_LCD12) | (BIT_LCD11) | _BV(BIT_LCD10) | _BV(BIT_LCD9) | _BV(BIT_LCD8);
    DDRD |= _BV(BIT_LED_YELLOW) | _BV(BIT_LED_GREEN);

    // SET PULLUP RESISTORS
    PORT_BUTTON |= _BV(BIT_BUTTON_GREEN) | _BV(BIT_BUTTON_YELLOW) | _BV(BIT_BUTTON_BLUE);
    PORT_ANALOG |= _BV(BIT_BRIGHT);

    // SET UP PD1-2 INTERRUPTS
    PCICR = _BV(PCIE2);
    PCMSK2 = _BV(PCINT19) | _BV(PCINT18);

    // SET TIMER INTERRUPTS
    // RESET TIMER 1 CONTROL REG A
    TCCR1A = 0;
    //SET PRESCALER TO 64
    TCCR1B &= ~_BV(CS12);
    TCCR1B |= _BV(CS11);
    TCCR1B |= _BV(CS10);
    TCNT1 = TIMER_1_START;
    OCR1A = TIMER_1_COMPARE; // RESET TIMER 1 AND COMPARE VALUE
    TIMSK1 = _BV(OCIE1A);    // ENABLE TIMER 1 OVERFLOW INTERRUPTS

    // RESET TIMER 2 CONTROL REG A
    TCCR2A = 0; // Reset Timer2 Control Reg A
    // Set to prescaler of 64
    TCCR2B |= _BV(CS22);
    TCCR2B &= ~_BV(CS21);
    TCCR2B &= ~_BV(CS20);
    TCNT2 = TIMER_2_START;
    OCR2A = TIMER_2_COMPARE; // RESET TIMER 2 AND COMPARE VALUE
    TIMSK2 = _BV(OCIE2A);    // ENABLE TIMER 2 OVERFLOW INTERRUPTS
    sei();

    // set up the LCD's number of columns and rows:
    lcd.begin(16, 2);
    // Print a message to the LCD.
}

void loop()
{

    if (mainEventFlags & FLAG_YELLOW)
    {
        // DELAY 20 MS
        isDelayRunning = 1;
        if (delayTimerTS <= 20)
        {
        }
        else
        {
            isDelayRunning = 0;
            delayTimerTS = 0;
            mainEventFlags &= ~FLAG_YELLOW;
            if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_YELLOW))
            {
                isYellowRunning = !isYellowRunning;
                PORT_LED ^= _BV(BIT_LED_YELLOW);
            }
        }
    }

    if (mainEventFlags & FLAG_GREEN)
    {
        isDelayRunning = 1;
        if (delayTimerTS <= 20)
        {
        }
        else
        {
            isDelayRunning = 0;
            delayTimerTS = 0;
            mainEventFlags &= ~FLAG_GREEN;
            if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_GREEN))
            {
                isGreenRunning = !isGreenRunning;
                PORT_LED ^= _BV(BIT_LED_GREEN);
            }
        }
    }

    blueState = bit_is_clear(PIN_BUTTON, BIT_BUTTON_BLUE);
    if (blueState != lastBlueState)
    {
        isDelayRunning = 1;
        if (delayTimerTS <= 50)
        {
        }
        else
        {
            isDelayRunning = 0;
            delayTimerTS = 0;
            if (!blueState)
            {
                PORT_LED &= ~_BV(BIT_LED_YELLOW);
                PORT_LED &= ~_BV(BIT_LED_GREEN);
                isYellowRunning = 0;
                yellowTimerTS = 0;
                isGreenRunning = 0;
                greenTimerTS = 0;
                lcd.clear();
            }
        }
    }
    lastBlueState = blueState;

    updateLCD();
}

void updateLCD()
{

    lcd.setCursor(0, 0);
    lcd.print(yellowTimerTS / 10);
    lcd.print(".");
    lcd.print(yellowTimerTS % 10);
    lcd.print("   ");
    lcd.setCursor(0, 1);
    if (!isGreenRunning)
    {
        lcd.print(greenTimerTS / 1000);
        lcd.print(".");
        lcd.print(greenTimerTS / 100 % 10);
        lcd.print("   ");
    }
}

ISR(PCINT2_vect)
{
    uint8_t changedbits;
    changedbits = PIND ^ portdhistory;
    portdhistory = PIND;

    if (changedbits & _BV(BIT_BUTTON_YELLOW))
    {
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_YELLOW))
        {
            mainEventFlags |= FLAG_YELLOW;
        }
    }

    if (changedbits & _BV(BIT_BUTTON_GREEN))
    {
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_GREEN))
        {
            mainEventFlags |= FLAG_GREEN;
        }
    }
}

ISR(TIMER1_COMPA_vect)
{
    TCNT1 = TIMER_1_START;
    if (isYellowRunning)
    {
        yellowTimerTS++;
    }
}

ISR(TIMER2_COMPA_vect)
{
    TCNT2 = TIMER_2_START;
    if (isGreenRunning)
    {
        greenTimerTS++;
    }
    if (isDelayRunning)
    {
        delayTimerTS++;
    }
}