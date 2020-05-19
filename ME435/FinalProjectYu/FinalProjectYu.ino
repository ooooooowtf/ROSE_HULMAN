#define BIT_ANA A0
#define BIT_BRIGHT A1

int potReading;
int redCounter = 0;
int yellowCounter = 0;
int greenCounter = 0;
int blueCounter = 0;

String inputString = "";              // a String to hold incoming data
volatile bool stringComplete = false; // whether the string is complete

//INTERRUPTS
// TRACK PORTD CHANGE
volatile uint8_t portdhistory = 0xFF;

//OUTPUT PORTS AND BITS
#define PORT_LED_RED PORTB
#define BIT_LED_RED 2
#define PORT_LED_YELLOW PORTB
#define BIT_LED_YELLOW 1
#define PORT_LED_GREEN PORTD
#define BIT_LED_GREEN 6
#define PORT_LED_BLUE PORTD
#define BIT_LED_BLUE 5

#define BIT_RGB_RED 11
#define BIT_RGB_GREEN 12
#define BIT_RGB_BLUE 13

//DEFINE INPUT PINS
#define PORT_BUTTON PORTD
#define PIN_BUTTON PIND
#define BIT_BUTTON_BLUE 2
#define BIT_BUTTON_GREEN 3
#define BIT_BUTTON_YELLOW 4
#define BIT_BUTTON_RED 7

// MAIN EVENT FLAG
volatile int mainEventFlags = 0;
#define FLAG_RED 0x01
#define FLAG_YELLOW 0x02
#define FLAG_GREEN 0x04
#define FLAG_BLUE 0x08

volatile int signalFlags = 0;
#define SIGNAL_RED 0x01
#define SIGNAL_YELLOW 0x02
#define SIGNAL_GREEN 0x04
#define SIGNAL_BLUE 0x08

unsigned long yellowTimerMS = 0;
uint8_t isYellowRunning = 0;
unsigned long redTimerMS = 0;
uint8_t isRedRunning = 0;
unsigned long greenTimerMS = 0;
uint8_t isGreenRunning = 0;
unsigned long blueTimerMS = 0;
uint8_t isBlueRunning = 0;

unsigned long priorTimeMS = 0;

void setup()
{
    // SET OUTPUT PORTS
    DDRB |= _BV(BIT_LED_RED) | _BV(BIT_LED_YELLOW);
    DDRD |= _BV(BIT_LED_GREEN) | _BV(BIT_LED_BLUE);

    // SET PULLUP RESISTORS
    PORT_BUTTON |= _BV(BIT_BUTTON_RED);
    PORT_BUTTON |= _BV(BIT_BUTTON_YELLOW);
    PORT_BUTTON |= _BV(BIT_BUTTON_GREEN);
    PORT_BUTTON |= _BV(BIT_BUTTON_BLUE);

    Serial.begin(9600);
    inputString.reserve(200);
    pinMode(LED_BUILTIN, OUTPUT);

    PCICR = _BV(PCIE2);
    PCMSK2 = _BV(PCINT19) | _BV(PCINT18) | _BV(PCINT20) | _BV(PCINT23);
    sei();
}

void loop()
{
    unsigned long currentTimeMS = millis();
    unsigned long elapsedTimeMS = currentTimeMS - priorTimeMS;
    priorTimeMS = currentTimeMS;

    ledONOFF();

    if (stringComplete)
    {
        // Do stuff with the message.
        if (inputString.equalsIgnoreCase("START RED"))
        {
            signalFlags |= SIGNAL_RED;
            isRedRunning = 1;
        }
        else if (inputString.equalsIgnoreCase("START YELLOW"))
        {
            signalFlags |= SIGNAL_YELLOW;
            isYellowRunning = 1;
        }
        else if (inputString.equalsIgnoreCase("START GREEN"))
        {
            signalFlags |= SIGNAL_GREEN;
            isGreenRunning = 1;
        }
        else if (inputString.equalsIgnoreCase("START BLUE"))
        {
            signalFlags |= SIGNAL_BLUE;
            isBlueRunning = 1;
        }else if(inputString.equalsIgnoreCase("RESTART"))
        {
            timerReset();
            signalFlags = 0;
            isRedRunning = 0;
            isYellowRunning = 0;
            isGreenRunning = 0;
            isBlueRunning = 0;
        }

        // Prepare for the next message
        inputString = "";
        stringComplete = false;
    }

    // interrupts();

    if (mainEventFlags & FLAG_RED)
    {
        delay(20);
        mainEventFlags &= ~FLAG_RED;
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_RED))
        {
            if (signalFlags & SIGNAL_RED)
            {
                isRedRunning = 0;
                Serial.print("POT ");
                Serial.print(redTimerMS / 1000);
                Serial.print(".");
                Serial.print(redTimerMS / 100 % 10);
                Serial.print(redTimerMS % 100 / 10);
                Serial.println(redTimerMS % 10);
                signalFlags &= ~SIGNAL_RED;
                timerReset();
            }
            else
            {
                Serial.println("ERROR ");
                timerReset();
            }
        }
    }

    if (mainEventFlags & FLAG_YELLOW)
    {
        delay(20);
        mainEventFlags &= ~FLAG_YELLOW;
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_YELLOW))
        {
            if (signalFlags & SIGNAL_YELLOW)
            {
                isYellowRunning = 0;
                Serial.print("POT ");
                Serial.print(yellowTimerMS / 1000);
                Serial.print(".");
                Serial.print(yellowTimerMS / 100 % 10);
                Serial.print(yellowTimerMS % 100 / 10);
                Serial.println(yellowTimerMS % 10);
                signalFlags &= ~SIGNAL_YELLOW;
                timerReset();
            }
            else
            {
                Serial.print("ERROR ");
                timerReset();
            }
        }
    }

    if (mainEventFlags & FLAG_GREEN)
    {
        delay(20);
        mainEventFlags &= ~FLAG_GREEN;
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_GREEN))
        {
            if (signalFlags & SIGNAL_GREEN)
            {
                isYellowRunning = 0;
                Serial.print("POT ");
                Serial.print(greenTimerMS / 1000);
                Serial.print(".");
                Serial.print(greenTimerMS / 100 % 10);
                Serial.print(greenTimerMS % 100 / 10);
                Serial.println(greenTimerMS % 10);
                signalFlags &= ~SIGNAL_GREEN;
                timerReset();
            }
            else
            {
                Serial.print("ERROR ");
                timerReset();
            }
        }
    }

    if (mainEventFlags & FLAG_BLUE)
    {
        delay(20);
        mainEventFlags &= ~FLAG_BLUE;
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_BLUE))
        {
            if (signalFlags & SIGNAL_BLUE)
            {
                isBlueRunning = 0;
                Serial.print("POT ");
                Serial.print(blueTimerMS / 1000);
                Serial.print(".");
                Serial.print(blueTimerMS / 100 % 10);
                Serial.print(blueTimerMS % 100 / 10);
                Serial.println(blueTimerMS % 10);
                signalFlags &= ~SIGNAL_BLUE;
                timerReset();
            }
            else
            {
                Serial.print("ERROR ");
                timerReset();
            }
        }
    }

    if (isRedRunning)
    {
        redTimerMS += elapsedTimeMS;
    }

    if (isYellowRunning)
    {
        yellowTimerMS += elapsedTimeMS;
    }

    if (isGreenRunning)
    {
        greenTimerMS += elapsedTimeMS;
    }

    if (isBlueRunning)
    {
        blueTimerMS += elapsedTimeMS;
    }
}

void timerReset()
{
    redTimerMS = 0;
    yellowTimerMS = 0;
    greenTimerMS = 0;
    blueTimerMS = 0;
    isRedRunning = 0;
    isYellowRunning = 0;
    isGreenRunning = 0;
    isBlueRunning = 0;
}
void ledONOFF()
{
    if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_RED))
    {
        PORT_LED_RED |= _BV(BIT_LED_RED);
    }
    else
    {
        PORT_LED_RED &= ~_BV(BIT_LED_RED);
    }

    if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_YELLOW))
    {
        PORT_LED_YELLOW |= _BV(BIT_LED_YELLOW);
    }
    else
    {
        PORT_LED_YELLOW &= ~_BV(BIT_LED_YELLOW);
    }

    if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_GREEN))
    {
        PORT_LED_GREEN |= _BV(BIT_LED_GREEN);
    }
    else
    {
        PORT_LED_GREEN &= ~_BV(BIT_LED_GREEN);
    }

    if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_BLUE))
    {
        PORT_LED_BLUE |= _BV(BIT_LED_BLUE);
    }
    else
    {
        PORT_LED_BLUE &= ~_BV(BIT_LED_BLUE);
    }
}

void serialEvent()
{
    while (Serial.available())
    {
        char inChar = (char)Serial.read();
        if (inChar == '\n')
        {
            stringComplete = true;
        }
        else
        {
            inputString += inChar;
        }
    }
}

ISR(PCINT2_vect)
{
    uint8_t changedbits;
    changedbits = PIND ^ portdhistory;
    portdhistory = PIND;

    if (changedbits & _BV(BIT_BUTTON_RED))
    {
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_RED))
        {
            mainEventFlags |= FLAG_RED;
        }
    }

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

    if (changedbits & _BV(BIT_BUTTON_BLUE))
    {
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_BLUE))
        {
            mainEventFlags |= FLAG_BLUE;
        }
    }
}