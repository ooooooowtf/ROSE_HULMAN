

//OUTPUT PORTS AND BITS
#define PORT_LED_RED PORTB
#define BIT_LED_RED 2
#define PORT_LED_YELLOW PORTB
#define BIT_LED_YELLOW 1
#define PORT_LED_GREEN PORTD
#define BIT_LED_GREEN 6
#define PORT_LED_BLUE PORTD
#define BIT_LED_BLUE 5

//INPUT PORTS AND BITS
#define PORT_BUTTON_RED PORTD
#define PIN_BUTTON_RED PIND
#define BIT_BUTTON_RED 3
#define PORT_BUTTON_YELLOW PORTD
#define PIN_BUTTON_YELLOW PIND
#define BIT_BUTTON_YELLOW 2
#define PORT_BUTTON_GREEN PORTD
#define PIN_BUTTON_GREEN PIND
#define BIT_BUTTON_GREEN 1
#define PORT_BUTTON_BLUE PORTD
#define PIN_BUTTON_BLUE PIND
#define BIT_BUTTON_BLUE 0

// MAIN EVENT FLAG
volatile int mainEventFlags = 0;
#define FLAG_RED 0x01
#define FLAG_YELLOW 0x02
#define FLAG_GREEN 0x04
#define FLAG_BLUE 0x08

// TRACK PORTD CHANGE
volatile uint8_t portdhistory = 0xFF;

uint8_t greenState = 1;
uint8_t blueState = 1;
uint8_t lastGreenState = 1;
uint8_t lastBlueState = 1;

uint8_t currentIndex = 0;
uint8_t savedLeds[10] = {BIT_LED_BLUE,
                         BIT_LED_BLUE,
                         BIT_LED_BLUE,
                         BIT_LED_BLUE,
                         BIT_LED_BLUE,
                         BIT_LED_BLUE,
                         BIT_LED_BLUE,
                         BIT_LED_BLUE,
                         BIT_LED_BLUE,
                         BIT_LED_BLUE};

void setup()
{
    //Serial.begin(9600);

    // SET OUTPUT PORTS
    DDRB |= _BV(BIT_LED_RED) | _BV(BIT_LED_YELLOW);
    DDRD |= _BV(BIT_LED_GREEN) | _BV(BIT_LED_BLUE);

    // SET PULLUP RESISTORS
    PORT_BUTTON_RED |= _BV(BIT_BUTTON_RED);
    PORT_BUTTON_YELLOW |= _BV(BIT_BUTTON_YELLOW);
    PORT_BUTTON_GREEN |= _BV(BIT_BUTTON_GREEN);
    PORT_BUTTON_BLUE |= _BV(BIT_BUTTON_BLUE);

    // ENABLE INTERRUPTS RD0-RD3
    PCICR = _BV(PCIE2);
    PCMSK2 = 0X0F;

    // ENABLE GLOBAL INTERRUPTS
    sei();
}

void loop()
{

    if (bit_is_clear(PORT_BUTTON_RED, BIT_BUTTON_RED))
    {
        PORT_LED_RED |= _BV(BIT_LED_RED);
    }
    else
    {
        PORT_LED_RED &= ~_BV(BIT_LED_RED);
    }

    if (bit_is_clear(PORT_BUTTON_YELLOW, BIT_BUTTON_YELLOW))
    {
        PORT_LED_YELLOW |= _BV(BIT_LED_YELLOW);
    }
    else
    {
        PORT_LED_YELLOW &= ~_BV(BIT_LED_YELLOW);
    }

    if (bit_is_clear(PORT_BUTTON_GREEN, BIT_BUTTON_GREEN))
    {
        PORT_LED_GREEN |= _BV(BIT_LED_GREEN);
    }
    else
    {
        PORT_LED_GREEN &= ~_BV(BIT_LED_GREEN);
    }

    if (bit_is_clear(PORT_BUTTON_BLUE, BIT_BUTTON_BLUE))
    {
        PORT_LED_BLUE |= _BV(BIT_LED_BLUE);
    }
    else
    {
        PORT_LED_BLUE &= ~_BV(BIT_LED_BLUE);
    }

    if (mainEventFlags & FLAG_RED)
    {
        delay(20);
        mainEventFlags &= ~FLAG_RED;
        if (bit_is_clear(PORT_BUTTON_RED, BIT_BUTTON_RED))
        {
            addLed(BIT_LED_RED);
        }
    }

    if (mainEventFlags & FLAG_YELLOW)
    {
        delay(20);
        mainEventFlags &= ~FLAG_YELLOW;
        if (bit_is_clear(PORT_BUTTON_YELLOW, BIT_BUTTON_YELLOW))
        {
            addLed(BIT_LED_YELLOW));
        }
    }

    if (mainEventFlags & FLAG_GREEN)
    {
        delay(20);
        mainEventFlags &= ~FLAG_GREEN;
        if (bit_is_clear(PORT_BUTTON_GREEN, BIT_BUTTON_GREEN))
        {
            addLed(BIT_LED_GREEN);
        }
    }

    if (mainEventFlags & FLAG_BLUE)
    {
        delay(20);
        mainEventFlags &= ~FLAG_BLUE;
        if (bit_is_clear(PORT_BUTTON_BLUE, BIT_BUTTON_BLUE))
        {
            runSequence();
        }
    }
}

void addLed(uint8_t newLedPin)
{
    if (currentIndex < sizeof(savedLeds))
    {
        savedLeds[currentIndex] = newLedPin;
        currentIndex++;
    }
}

void runSequence()
{
    PORT_LED_BLUE &= ~_BV(BIT_LED_BLUE);

    for (int k = 0; k < sizeof(savedLeds); k++)
    {
        uint8_t activeLedPin = savedLeds[k];
        if (activeLedPin == BIT_LED_RED || activeLedPin == BIT_LED_YELLOW)
        {
            PORT_LED_RED |= _BV(activeLedPin);
        }
        else
        {
            PORT_LED_GREEN |= _BV(activeLedPin);
        }
        delay(1000);
        if (activeLedPin == BIT_LED_RED || activeLedPin == BIT_LED_YELLOW)
        {
            PORT_LED_RED &= ~_BV(activeLedPin);
        }
        else
        {
            PORT_LED_GREEN &= ~_BV(activeLedPin);
        }
        delay(100);
    }
    currentIndex = 0;
    savedLeds[0] = BIT_LED_BLUE;
    savedLeds[1] = BIT_LED_BLUE;
    savedLeds[2] = BIT_LED_BLUE;
    savedLeds[3] = BIT_LED_BLUE;
    savedLeds[4] = BIT_LED_BLUE;
    savedLeds[5] = BIT_LED_BLUE;
    savedLeds[6] = BIT_LED_BLUE;
    savedLeds[7] = BIT_LED_BLUE;
    savedLeds[8] = BIT_LED_BLUE;
    savedLeds[9] = BIT_LED_BLUE;
}

ISR(PCINT2_vect)
{
    uint8_t changedbits;
    changedbits = PIND ^ portdhistory;
    portdhistory = PIND;

    if (changedbits & _BV(BIT_BUTTON_RED))
    {
        if (bit_is_clear(PIN_BUTTON_RED,BIT_BUTTON_RED){
            mainEventFlags |= FLAG_RED;
        }
    }

    if (changedbits & _BV(BIT_BUTTON_YELLOW))
    {
        if (bit_is_clear(PIN_BUTTON_YELLOW,BIT_BUTTON_YELLOW){
            mainEventFlags |= FLAG_YELLOW;
        }
    }

    if (changedbits & _BV(BIT_BUTTON_GREEN))
    {
        if (bit_is_clear(PIN_BUTTON_GREEN,BIT_BUTTON_GREEN){
            mainEventFlags |= FLAG_GREEN;
        }
    }

    if (changedbits & _BV(BIT_BUTTON_BLUE))
    {
        if (bit_is_clear(PIN_BUTTON_BLUE,BIT_BUTTON_BLUE){
            mainEventFlags |= FLAG_BLUE;
        }
    }
}