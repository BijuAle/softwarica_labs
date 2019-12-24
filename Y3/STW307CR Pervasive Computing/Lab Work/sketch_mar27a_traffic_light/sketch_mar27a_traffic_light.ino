int ledRed = 11;
int ledYellow = 12;
int ledGreen = 13;
int ledPedestrian = 10;

void setup() {
  pinMode(ledRed, OUTPUT);
  pinMode(ledYellow, OUTPUT);
  pinMode(ledGreen, OUTPUT);
  pinMode(ledPedestrian, OUTPUT);
}

void loop() {
  digitalWrite(ledRed, HIGH);
  digitalWrite(ledPedestrian, HIGH);  
  delay(5000);
  
  digitalWrite(ledRed, LOW);
  digitalWrite(ledYellow, HIGH);
  delay(5000);
  
  digitalWrite(ledYellow, LOW);
  digitalWrite(ledGreen, HIGH);
   digitalWrite(ledPedestrian, LOW);
  delay(5000);
  digitalWrite(ledGreen, LOW);
}
