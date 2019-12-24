const int xpin = A0,
          ypin = A1,
          zpin = A2;

float zero_G = 512.0; //ADC is 0~1023 the zero g output equal to Vs/2
float scale = 102.3; //ADXL335330 Sensitivity is 330mv/g

void setup()
{
  Serial.begin(9600);
}

void loop()
{
  int x = analogRead(xpin);
  delay(1);
  int y = analogRead(ypin);
  delay(1);
  int z = analogRead(zpin);

  //330 * 1024/3.3/1000
  float _x  = ((float)x - 331.5) / 65 * 9.8;
  float _y = ((float)y - 329.5) / 68.5 * 9.8;
  float _z = ((float)z - 340) / 68 * 9.8;
  delay(1000); //wait for 1 second

  Serial.print(_x);
  Serial.print("\t");
  Serial.print(_y);
  Serial.print("\t");
  Serial.print(_z);
  Serial.print("\n");

  if (bikeUpTurn(_x, _y, _z)) {
    Serial.println("Upturned");
  }
}

//bikeRightFlip() {} //11.00,1.20,-0.10
//bikeLeftFlip() {} //-9.40,1.20,0.70

boolean bikeUpTurn(float _x, float _y, float _z) {
  boolean status = false;
  if (_x > 1.00 && _y > 1.20 && _z > 10.50) {
    status = true;
  }
  return status;
}
