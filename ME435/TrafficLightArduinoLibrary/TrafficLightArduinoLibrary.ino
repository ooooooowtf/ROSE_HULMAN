
#define redLight 13
#define yellowLight 12
#define greenLight 11
#define pressButton 0

void setup()
{
    Serial.begin(9600)
  pinMode(redLight, OUTPUT);
  pinMode(yellowLight, OUTPUT);
  pinMode(greenLight, OUTPUT);
  pinMode(pressButton, INPUT);
  digitalWrite(greenLight, LOW);  
  digitalWrite(yellowLight, LOW);
  digitalWrite(redLight, LOW);
}

void loop()
{
  
  if(digitalRead(pressButton)==0){
    digitalWrite(greenLight, LOW); 
  	digitalWrite(yellowLight, LOW);
  	digitalWrite(redLight, LOW);
  	digitalWrite(greenLight, HIGH);
  	delay(2000);
    while(digitalRead(pressButton)==0);
  	digitalWrite(greenLight, LOW);
  	digitalWrite(yellowLight, HIGH);
  	delay(1000); // Wait for 1000 millisecond(s)
  	digitalWrite(yellowLight, LOW);
  	
  	
  }
  digitalWrite(redLight, HIGH);
}

