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

uint8_t yellowCounter = 0;
uint8_t greenCounter = 0;

volatile uint8_t timeCounter = 0;

volatile uint8_t readA0 = 0;
void setup()
{
    // SET OUTPUTS
    DDRB |= _BV(BIT_LCD13) | _BV(BIT_LCD12) | (BIT_LCD11) | _BV(BIT_LCD10) | _BV(BIT_LCD9) | _BV(BIT_LCD8);
    DDRD |= _BV(BIT_LED_YELLOW) | _BV(BIT_LED_GREEN);


    // SET PULLUP RESISTORS
    PORT_BUTTON |= _BV(BIT_BUTTON_GREEN) | _BV(BIT_BUTTON_YELLOW) | _BV(BIT_BUTTON_BLUE);
    PORT_ANALOG |= _BV(BIT_BRIGHT);

    // SET UP PD1-3 INTERRUPTS
    PCICR = _BV(PCIE2);
    PCMSK2 = _BV(PCINT19) | _BV(PCINT18);

    sei();

    Serial.begin(9600);
    // set up the LCD's number of columns and rows:
    lcd.begin(16, 2);
    // Print a message to the LCD.
}

void loop()
{
    timeCounter += 1;
    if(timeCounter>=50){
        readA0 = analogRead(BIT_BRIGHT);
        Serial.print("Pot = ");
        Serial.println(readA0);
        timeCounter = 0;
    }
    
    // if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_YELLOW))
    // {
    //     PORT_LED |= _BV(BIT_LED_YELLOW);
    // }
    // else
    // {
    //     PORT_LED &= ~_BV(BIT_LED_YELLOW);
    // }

    // if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_GREEN))
    // {
    //     PORT_LED |= _BV(BIT_LED_GREEN);
    // }
    // else
    // {
    //     PORT_LED &= ~_BV(BIT_LED_GREEN);
    // }

    if (mainEventFlags & FLAG_YELLOW)
    {
        delay(20);
        mainEventFlags &= ~FLAG_YELLOW;
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_YELLOW))
        {
            Serial.println("PRESSED YELLOW");
            yellowCounter = yellowCounter + 1;
            PORT_LED |= _BV(BIT_LED_YELLOW);
            PORT_LED &= ~_BV(BIT_LED_GREEN);
        }
    }

    if (mainEventFlags & FLAG_GREEN)
    {
        delay(20);
        mainEventFlags &= ~FLAG_GREEN;
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_GREEN))
        {
            
            Serial.println("PRESSED GREEN");
            greenCounter = greenCounter + 1;
            PORT_LED |= _BV(BIT_LED_GREEN);
            PORT_LED &= ~_BV(BIT_LED_YELLOW);
        }
    }

    blueState = digitalRead(BIT_BUTTON_BLUE);
    if (blueState != lastBlueState)
    {
        if (!blueState)
        {
            Serial.println("PRESSED BLUE");
            yellowCounter = 0;
            greenCounter = 0;
            PORT_LED &= ~_BV(BIT_LED_YELLOW);
            PORT_LED &= ~_BV(BIT_LED_GREEN);
        }
        delay(50); // Delay a little bit to avoid bouncing
    }
    lastBlueState = blueState;

    // set the cursor to column 0, line 1
    // (note: line 1 is the second row, since counting begins with 0):
    lcd.setCursor(0, 0);
    // print the number of seconds since reset:
    lcd.print("Bill Yu");
    lcd.setCursor(0, 1);
    lcd.print("Y=");
    lcd.print(yellowCounter);
    lcd.print(" ");
    lcd.print("G=");
    lcd.print(greenCounter);
    lcd.print(" ");
    lcd.print(millis() / 1000);
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