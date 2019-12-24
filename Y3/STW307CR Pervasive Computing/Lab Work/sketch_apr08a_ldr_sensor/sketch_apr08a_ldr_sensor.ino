int ldrPin = A0; // select the input pin for LDR
int sensorValue = 0; // variable to store the value coming from the sensor

float outputVal;
int led = 14;

void setup() {
  Serial.begin(9600); //sets serial port for communication
}

void loop() {
  sensorValue = analogRead(ldrPin); // read the value from the sensor
  Serial.println(sensorValue); //prints the values coming from the sensor on the screen
  delay(100);

  outputVal = map(sensorValue, 0, 1023, 0, 255);
  analogWrite(led, outputVal);
}
