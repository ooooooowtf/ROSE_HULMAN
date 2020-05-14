// #define redLight 13
// #define yellowLight 12
// #define greenLight 11
// #define pressButton 0

void setup()
{

    //   pinMode(redLight, OUTPUT);
    //   pinMode(yellowLight, OUTPUT);
    //   pinMode(greenLight, OUTPUT);
    DDRB |= _BV(DDB5);
    DDRB |= _BV(DDB4);
    DDRB |= _BV(DDB3);
    //   pinMode(pressButton, INPUT);
    DDRD &= ~_BV(DDD0);
    PORTD |= _BV(PORTD0);
    noLight();
}

void loop()
{

    if (bit_is_clear(PIND,PIND0))
    {
        greenLight();
        delay(2000);
        while (bit_is_clear(PIND,PIND0))
            ;
        yellowLight();
        delay(1000); // Wait for 1000 millisecond(s)
        
    }
    redLight();
}

void greenLight()
{
    PORTB &= ~_BV(PORTB5);
    PORTB &= ~_BV(PORTB4);
    PORTB |= _BV(PORTB3);
}

void yellowLight()
{
    PORTB &= ~_BV(PORTB5);
    PORTB |= _BV(PORTB4);
    PORTB &= ~_BV(PORTB3);
}

void redLight()
{
    PORTB |= _BV(PORTB5);
    PORTB &= ~_BV(PORTB4);
    PORTB &= ~_BV(PORTB3);
}

void noLight()
{
    PORTB &= ~_BV(PORTB5);
    PORTB &= ~_BV(PORTB4);
    PORTB &= ~_BV(PORTB3);
}
