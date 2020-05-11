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

unsigned long yellowTimerMS = 0;
uint8_t isYellowRunning = 0;
unsigned long greenTimerMS = 0;
uint8_t isGreenRunning = 0;

unsigned long priorTimeMS = 0;
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

    
    // set up the LCD's number of columns and rows:
    lcd.begin(16, 2);
    // Print a message to the LCD.
}

void loop()
{
  	
  	unsigned long currentTimeMS = millis();
  	unsigned long elapsedTimeMS = currentTimeMS-priorTimeMS;
  	priorTimeMS = currentTimeMS;
  
   	if (mainEventFlags & FLAG_YELLOW)
    {
        delay(20);
        mainEventFlags &= ~FLAG_YELLOW;
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_YELLOW))
        {
          	isYellowRunning = !isYellowRunning;
            PORT_LED ^= _BV(BIT_LED_YELLOW);
            
        }
    }

    if (mainEventFlags & FLAG_GREEN)
    {
        delay(20);
        mainEventFlags &= ~FLAG_GREEN;
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_GREEN))
        {
            isGreenRunning = !isGreenRunning;
            PORT_LED ^= _BV(BIT_LED_GREEN);
            
        }
    }

    blueState = digitalRead(BIT_BUTTON_BLUE);
    if (blueState != lastBlueState)
    {
        if (!blueState)
        {            
            PORT_LED &= ~_BV(BIT_LED_YELLOW);
            PORT_LED &= ~_BV(BIT_LED_GREEN);
          	isYellowRunning = 0;
          	yellowTimerMS = 0;
          	isGreenRunning = 0;
          	greenTimerMS = 0;
          	lcd.clear();
        }
        delay(50); // Delay a little bit to avoid bouncing
    }
    lastBlueState = blueState;

    
   
    
  	
  if(isYellowRunning){
    yellowTimerMS += elapsedTimeMS;
  }
  
  if(isGreenRunning){
    greenTimerMS += elapsedTimeMS;
  }
  updateLCD();
  
}

void updateLCD(){
	
    lcd.setCursor(0, 0);
    lcd.print(yellowTimerMS/1000);
  	lcd.print(".");
    lcd.print(yellowTimerMS/100 % 10);
  	lcd.print("   ");
    lcd.setCursor(0, 1);
  if(!isGreenRunning){
    lcd.print(greenTimerMS/1000);
  	lcd.print(".");
    lcd.print(greenTimerMS/100 % 10);
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