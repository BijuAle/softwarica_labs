const int trigPin = 12;
const int echoPin = 13;

int ledGreen = 11;
int ledRed = 10;


float duration, distance;

void setup() {
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  Serial.begin(9600);

  pinMode(ledGreen, OUTPUT);
  pinMode(ledRed, OUTPUT);
}

void loop() {
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  duration = pulseIn(echoPin, HIGH);
  distance = (duration*.0343/2);

  Serial.print("Distance: ");
  Serial.println(distance);
  delay(100);

  if (distance >12){
    digitalWrite(ledGreen, HIGH);
    digitalWrite(ledRed, LOW);
  }
  else{
    digitalWrite(ledRed, HIGH);
    digitalWrite(ledGreen, LOW);
  }
}

/*
 * int inches = 0;
int cm = 0;

long readUltraSonicDistance(int triggerPin, int echoPin{
  pinMode(triggerPin, OUTPUT);
  digitalWrite(triggerPin, LOW);
  delyaMicroseconds(2);

//Set the trigger pin to HIGH state for 10 microseconds
  digitalWrite(triggerPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(triggerPin, LOW);
*/
