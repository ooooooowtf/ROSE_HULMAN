// INPUT BUTTON
#define PORT_BUTTON PORTD
#define BIT_BUTTON_BLUE 2
#define BIT_BUTTON_GREEN 3
#define BIT_BUTTON_YELLOW 4
#define BIT_BUTTON_RED 7

#define BIT_ANA A0
#define BIT_BRIGHT A1

// OUTPUT LED/RGB
#define BIT_LED_BLUE 5
#define BIT_LED_GREEN 6
#define BIT_LED_YELLOW 9
#define BIT_LED_RED 10

#define BIT_RGB_RED 11
#define BIT_RGB_GREEN 12
#define BIT_RGB_BLUE 13

// MAIN EVENT FLAG
volatile int mainEventFlags = 0;
#define FLAG_GREEN 0x01
#define FLAG_BLUE 0x02

//TIMER AND COUNTER
uint8_t counter = 0;
unsigned long priorTimeMS = 0;

void setup()
{        
    // SET OUTPUTS
    pinMode(BIT_LED_BLUE, OUTPUT);
    pinMode(BIT_LED_GREEN, OUTPUT);
    pinMode(BIT_LED_YELLOW, OUTPUT);
    pinMode(BIT_LED_RED, OUTPUT);

    pinMode(BIT_RGB_RED, OUTPUT);
    pinMode(BIT_RGB_GREEN, OUTPUT);
    pinMode(BIT_RGB_BLUE, OUTPUT);

    digitalWrite(BIT_LED_BLUE, LOW);
    digitalWrite(BIT_LED_GREEN, LOW);
    digitalWrite(BIT_LED_YELLOW, LOW);
    digitalWrite(BIT_LED_RED, LOW);

    digitalWrite(BIT_RGB_RED, LOW);
    digitalWrite(BIT_RGB_GREEN, LOW);
    digitalWrite(BIT_RGB_BLUE, LOW);

    // SET PULLUP RESISTORS
    pinMode(BIT_BUTTON_BLUE, INPUT_PULLUP);
    pinMode(BIT_BUTTON_GREEN, INPUT_PULLUP);
    pinMode(BIT_BUTTON_YELLOW, INPUT_PULLUP);
    pinMode(BIT_BUTTON_RED, INPUT_PULLUP);

    // SET UP PD1-2 INTERRUPTS
    attachInterrupt(digitalPinToInterrupt(BIT_BUTTON_GREEN), green_isr, FALLING);
    attachInterrupt(digitalPinToInterrupt(BIT_BUTTON_BLUE), blue_isr, FALLING);

    // SERIAL BEGIN
    Serial.begin(9600);
}

void loop()
{
    digitalWrite(BIT_LED_BLUE,!digitalRead(BIT_BUTTON_BLUE));
    digitalWrite(BIT_LED_GREEN,!digitalRead(BIT_BUTTON_GREEN));
    digitalWrite(BIT_LED_YELLOW,!digitalRead(BIT_BUTTON_YELLOW));
    digitalWrite(BIT_LED_RED,!digitalRead(BIT_BUTTON_RED));

    int potVal = analogRead(BIT_ANA);
    int photoVal = analogRead(BIT_BRIGHT);

    unsigned long currentTimeMS = millis();
  	unsigned long elapsedTimeMS = currentTimeMS-priorTimeMS;
    if (elapsedTimeMS > 2000)
    {
        Serial.print("Pot = ");
        Serial.print(potVal);
        Serial.print(" Photoresistor = ");
        Serial.println(photoVal);
    }


    if (mainEventFlags & FLAG_GREEN)
    {
        delay(20);
        mainEventFlags &= ~FLAG_GREEN;
        if (!digitalRead(BIT_BUTTON_GREEN))
        {
            counter = 0;
            updateRgb();
        }
    }
    if (mainEventFlags & FLAG_BLUE)
    {
        delay(20);
        mainEventFlags &= ~FLAG_BLUE;
        if (!digitalRead(BIT_BUTTON_BLUE))
        {
            counter += 1;
            if (counter > 7)
            {
                counter = 0;
            }
            updateRgb();
        }
    }
    delay(100);
}

// update function from Dr.Fisher's GITHUB
void updateRgb()
{
    digitalWrite(BIT_RGB_RED, counter >> 2 & 0x01);
    digitalWrite(BIT_RGB_GREEN, counter >> 1 & 0x01);
    digitalWrite(BIT_RGB_BLUE, counter >> 0 & 0x01);
}


// BLUE ISR
void blue_isr()
{
    mainEventFlags |= FLAG_BLUE;
}

// GREEN ISR
void green_isr()
{
    mainEventFlags |= FLAG_GREEN;
}