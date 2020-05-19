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

volatile uint8_t isRED = 0;
volatile uint8_t isYELLOW = 0;
volatile uint8_t isGREEN = 0;
volatile uint8_t isBLUE = 0;

volatile uint8_t rgbCount = 0;
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
    ledONOFF();

    if (stringComplete)
    {
        // Do stuff with the message.
        if (inputString.equalsIgnoreCase("ON"))
        {
            digitalWrite(LED_BUILTIN, HIGH);
        }
        else if (inputString.equalsIgnoreCase("OFF"))
        {
            digitalWrite(LED_BUILTIN, LOW);
        }
        else if (inputString.equalsIgnoreCase("ADC"))
        {
            int potVal = analogRead(BIT_ANA);
            int photoVal = analogRead(BIT_BRIGHT);

            Serial.print("POT ");
            Serial.print(potVal);
            Serial.print(" ");
            Serial.println(photoVal);
        }
        else if (inputString.equalsIgnoreCase("REDON"))
        {
            Serial.println("RED ON ");
            isRED = 1;
        }
        else if (inputString.equalsIgnoreCase("REDOFF"))
        {
            Serial.println("RED OFF ");
            isRED = 0;
        }
        else if (inputString.equalsIgnoreCase("GREENON"))
        {
            Serial.println("GREEN ON ");
            isGREEN = 1;
        }
        else if (inputString.equalsIgnoreCase("GREENOFF"))
        {
            Serial.println("GREEN OFF ");
            isGREEN = 0;
        }
        else if (inputString.equalsIgnoreCase("BLUEON"))
        {
            Serial.println("BLUE ON ");
            isBLUE = 1;
        }
        else if (inputString.equalsIgnoreCase("BLUEOFF"))
        {
            Serial.println("BLUE OFF ");
            isBLUE = 0;
        }
        else if (inputString.equalsIgnoreCase("YELLOWON"))
        {
            Serial.println("YELLOW ON ");
            isYELLOW = 1;
        }
        else if (inputString.equalsIgnoreCase("YELLOWOFF"))
        {
            Serial.println("YELLOW OFF ");
            isYELLOW = 0;
        }
        else if (inputString.equalsIgnoreCase("RGBOFF"))
        {
            Serial.println("RGB OFF ");
            rgbCount = 0;
            updateRgb();
        }
        
        else if (inputString.equalsIgnoreCase("RGBBLUE"))
        {
            Serial.println("RGB BLUE ");
            rgbCount = 1;
            updateRgb();
        }
        else if (inputString.equalsIgnoreCase("RGBGREEN"))
        {
            Serial.println("RGB GREEN ");
            rgbCount = 2;
            updateRgb();
        }
        else if (inputString.equalsIgnoreCase("RGBCYAN"))
        {
            Serial.println("RGB CYAN ");
            rgbCount = 3;
            updateRgb();
        }
        else if (inputString.equalsIgnoreCase("RGBRED"))
        {
            Serial.println("RGB RED ");
            rgbCount = 4;
            updateRgb();
        }
        else if (inputString.equalsIgnoreCase("RGBPURPLE"))
        {
            Serial.println("RGB PURPLE ");
            rgbCount = 5;
            updateRgb();
        }

        else if (inputString.equalsIgnoreCase("RGBYELLOW"))
        {
            Serial.println("RGB YELLOW ");
            rgbCount = 6;
            updateRgb();
        }
        else if (inputString.equalsIgnoreCase("RGBWHITE"))
        {
            Serial.println("RGB WHITE ");
            rgbCount = 7;
            updateRgb();
        }

        // Prepare for the next message
        inputString = "";
        stringComplete = false;
    }

    // interrupts();

    if (mainEventFlags & FLAG_YELLOW)
    {
        delay(20);
        mainEventFlags &= ~FLAG_YELLOW;
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_YELLOW))
        {
            Serial.print("PRESSED YELLOW");
            Serial.println(" ");
            
        }
    }

    if (mainEventFlags & FLAG_GREEN)
    {
        delay(20);
        mainEventFlags &= ~FLAG_GREEN;
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_GREEN))
        {
            Serial.print("PRESSED GREEN");
            Serial.println(" ");
        }
    }

    if (mainEventFlags & FLAG_BLUE)
    {
        delay(20);
        mainEventFlags &= ~FLAG_BLUE;
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_BLUE))
        {
            Serial.print("PRESSED BLUE");
            Serial.println(" ");
        }
    }

    if (mainEventFlags & FLAG_RED)
    {
        delay(20);
        mainEventFlags &= ~FLAG_RED;
        if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_RED))
        {
            Serial.print("PRESSED RED");
            Serial.println(" ");
            
        }
    }
}

// update function from Dr.Fisher's GITHUB
void updateRgb()
{
    digitalWrite(BIT_RGB_RED, rgbCount >> 2 & 0x01);
    digitalWrite(BIT_RGB_GREEN, rgbCount >> 1 & 0x01);
    digitalWrite(BIT_RGB_BLUE, rgbCount >> 0 & 0x01);
}

void ledONOFF()
{
    if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_RED)||isRED == 1)
    {
        PORT_LED_RED |= _BV(BIT_LED_RED);
    }
    else
    {
        PORT_LED_RED &= ~_BV(BIT_LED_RED);
    }

    if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_YELLOW)||isYELLOW == 1)
    {
        PORT_LED_YELLOW |= _BV(BIT_LED_YELLOW);
    }
    else
    {
        PORT_LED_YELLOW &= ~_BV(BIT_LED_YELLOW);
    }

    if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_GREEN)||isGREEN == 1)
    {
        PORT_LED_GREEN |= _BV(BIT_LED_GREEN);
    }
    else
    {
        PORT_LED_GREEN &= ~_BV(BIT_LED_GREEN);
    }

    if (bit_is_clear(PIN_BUTTON, BIT_BUTTON_BLUE)||isBLUE == 1)
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