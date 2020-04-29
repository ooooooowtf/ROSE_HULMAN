
#define redLight 11
#define yellowLight 10
#define greenLight 6
#define blueLight 5

#define pressRed 3
#define pressYellow 2
#define pressGreen 1
#define pressBlue 0

volatile int mainEventFlags = 0;
#define FLAG_RED 0x01
#define FLAG_YELLOW 0x02
//#define FLAG_GREEN 0x04
//#define FLAG_BLUE 0x08

uint8_t greenState = 1;
uint8_t blueState = 1;
uint8_t lastGreenState = 1;
uint8_t lastBlueState = 1;

uint8_t currentIndex = 0;
uint8_t savedLeds[10] = {blueLight,
                        blueLight,
                        blueLight,
                        blueLight,
                        blueLight,
                        blueLight,
                        blueLight,
                        blueLight,
                        blueLight,
                        blueLight};

void setup()
{
  //Serial.begin(9600);
  pinMode(redLight, OUTPUT);
  pinMode(yellowLight, OUTPUT);
  pinMode(greenLight, OUTPUT);
  pinMode(blueLight, OUTPUT);
  
  pinMode(pressRed, INPUT_PULLUP);
  pinMode(pressYellow, INPUT_PULLUP);
  pinMode(pressGreen, INPUT_PULLUP);
  pinMode(pressBlue, INPUT_PULLUP);
  
  attachInterrupt(digitalPinToInterrupt(pressRed), red_pushbutton_isr, FALLING);
  attachInterrupt(digitalPinToInterrupt(pressYellow), yellow_pushbutton_isr, FALLING);
  

}

void loop()
{
  digitalWrite(redLight,!digitalRead(pressRed));
  digitalWrite(yellowLight,!digitalRead(pressYellow));
  digitalWrite(greenLight,!digitalRead(pressGreen));
  digitalWrite(blueLight,!digitalRead(pressBlue));
  
   if (mainEventFlags & FLAG_RED) {
    delay(20);
    mainEventFlags &= ~FLAG_RED;
    if (!digitalRead(pressRed)) {
      addLed(redLight);
    }
  }
  
  if (mainEventFlags & FLAG_YELLOW) {
    delay(20);
    mainEventFlags &= ~FLAG_YELLOW;
    if (!digitalRead(pressYellow)) {
      addLed(yellowLight);
    }
  }
  greenState = digitalRead(pressGreen);
  if (greenState != lastGreenState) {
    if (!greenState) {
      addLed(greenLight);
    }
    delay(50);  // Delay a little bit to avoid bouncing
  }
  lastGreenState = greenState;

  blueState = digitalRead(pressBlue);
  if (blueState != lastBlueState) {
    if (!blueState) {
      runSequence();
    }
    delay(50);  // Delay a little bit to avoid bouncing
  }
  lastBlueState = blueState;
  
//  if (mainEventFlags & FLAG_GREEN) {
//    delay(20);
//    mainEventFlags &= ~FLAG_GREEN;
//    if (!digitalRead(pressGreen)) {
//      addLed(greenLight);
//    }
//  }
//  
//  if (mainEventFlags & FLAG_BLUE) {
//    delay(20);
//    mainEventFlags &= ~FLAG_BLUE;
//    if (!digitalRead(pressBlue)) {
//      runSequence();
//    }
//  }
//  
}

void addLed(uint8_t newLedPin) {
  if (currentIndex < sizeof(savedLeds)) {
    savedLeds[currentIndex] = newLedPin;
    currentIndex++;
  }
}

void runSequence() {
  digitalWrite(blueLight, LOW);
  for (int k = 0; k < sizeof(savedLeds); k++) {
    uint8_t activeLedPin = savedLeds[k];
    digitalWrite(activeLedPin, HIGH);
    delay(1000);
    digitalWrite(activeLedPin, LOW);
    delay(100);
  }
  currentIndex = 0;
  savedLeds[0] = blueLight;
  savedLeds[1] = blueLight;
  savedLeds[2] = blueLight;
  savedLeds[3] = blueLight;
  savedLeds[4] = blueLight;
  savedLeds[5] = blueLight;
  savedLeds[6] = blueLight;
  savedLeds[7] = blueLight;
  savedLeds[8] = blueLight;
  savedLeds[9] = blueLight;
}

void yellow_pushbutton_isr() {
  mainEventFlags |= FLAG_YELLOW;
}

void red_pushbutton_isr() {
  mainEventFlags |= FLAG_RED;
}

//void blue_pushbutton_isr() {
//  mainEventFlags |= FLAG_BLUE;
//}
//
//void green_pushbutton_isr() {
//  mainEventFlags |= FLAG_GREEN;
//}