#define MQ2Pin (0)
float sensorValue;

int redLed = 12;
int blueLed = 13;

void setup() {
  pinMode(MQ2Pin, INPUT);
  pinMode(redLed, OUTPUT);
  pinMode(blueLed, OUTPUT);
  
  Serial.begin(9600); 
  Serial.println("Gas Sensor warming up.");
  delay(20000);
}

void loop() {
  sensorValue = analogRead(MQ2Pin);
  Serial.println("Sensor Value: ");
  Serial.println(sensorValue);
  delay(200);

  if(sensorValue>100){
    Serial.print(" | Smoke Detected.");
    digitalWrite(redLed, HIGH);
    digitalWrite(blueLed, LOW);
  }
  else{
    digitalWrite(redLed, LOW);
    digitalWrite(blueLed, HIGH);
  }
}
