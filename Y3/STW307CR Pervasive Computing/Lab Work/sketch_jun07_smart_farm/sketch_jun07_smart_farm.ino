#include <TinyGPS++.h>
#include <SoftwareSerial.h>
#include <DHT.h>

//Pins for Color Sensor - GY-31 / TCS250
#define S0 6
#define S1 7
#define S2 2
#define S3 3
#define sensorOut 4
int frequency = 0;

//Pins for Temperature-Humidity Sensor - DHT22
#define DHTPIN 13
#define DHTTYPE DHT22 // Select DHT sensor model.
DHT dht(DHTPIN, DHTTYPE);
//int timeSinceLastRead = 0;

//Pins for moisture sensor & water motor
String moistureStatus;
int pinSensor = A1,
    pinMotor = 5,
    moistureValue;

//Pins for GPS
static const int RX_GPS = 9,
                 TX_GPS = 10;
float valLat = 28.3949,
      valLng = 84.1240;
TinyGPSPlus gps;
SoftwareSerial ssGPS = SoftwareSerial(TX_GPS, RX_GPS);

//Pins for Sense Light
int blueLedPin = 14, //D5
    lightSensorPin = A0,
    sensedLightLevel = 0;
float lightIntensity;

void setup() {
  //GPS Setup
  Serial.begin(115200);
  ssGPS.begin(9600);

  //Moisture sensor & Water motor pins
  pinMode(pinSensor, INPUT);
  pinMode(pinMotor, OUTPUT);

  //Color Sensor Setup
  pinMode(S0, OUTPUT);
  pinMode(S1, OUTPUT);
  pinMode(S2, OUTPUT);
  pinMode(S3, OUTPUT);
  pinMode(sensorOut, INPUT);

  //Setting frequency-scaling to 100%
  digitalWrite(S0, HIGH);
  digitalWrite(S1, HIGH);

  //DHT22 Setup
  dht.begin();
}

void loop() {
  senseMoisture();
  Serial.print(",");
  getGPSCoords();
  Serial.print(",");
  senseTempHumid();
  Serial.print(",");
  senseColor();
  Serial.print(",");
  Serial.print("X");
}

void senseMoisture() {
  delay(1000);
  moistureValue = analogRead(pinSensor);
  //  Serial.print("Moisture Level: ");
  //  Serial.println(moistureValue);
  if (moistureValue > 600) { //If soil is dry
    //    Serial.print("LOW");
    digitalWrite(pinMotor, LOW);
    delay(5000);
    digitalWrite(pinMotor, HIGH);
    if (analogRead(pinSensor) < 600) {
      //Serial.print("HIGH");
    }
    Serial.print("LOW");
  } else if (moistureValue < 600) {
    Serial.print("HIGH");
  }

}

void getGPSCoords() {
  //  while (ssGPS.available() > 0) {
  //    gps.encode(ssGPS.read());
  //    if (gps.location.isUpdated()) {
  //      valLat = (gps.location.lat(), 6);
  //      Serial.print("Latitude = ");
  //      Serial.print(valLat);
  //
  //      valLng = (gps.location.lng(), 6);
  //      Serial.print(" Longitude = ");
  //      Serial.println(valLng);
  //    }
  //  }
  Serial.print(String(valLat));
  Serial.print(",");
  Serial.print(String(valLng));
}

void senseTempHumid() {

  float h = dht.readHumidity();
  float t = dht.readTemperature();
  // Check if any reads failed and exit early (to try again).
  if (isnan(h) || isnan(t)) {
    h = 0;
    t = 0;
    //Serial.println("Failed to read from DHT sensor!");
    //return;
  }

  float hic = dht.computeHeatIndex(t, h, false);// Compute heat index in Celsius (isFahreheit = false)
  Serial.print(h);
  Serial.print(",");
  Serial.print(t);
  Serial.print(",");
  Serial.print(hic);
  delay(100);
}

void senseLight() {

  sensedLightLevel = analogRead(lightSensorPin); // read the value from the sensor
  Serial.print("Light level");
  Serial.println(sensedLightLevel); //prints the values coming from the sensor on the screen
  delay(100);

  lightIntensity = map(sensedLightLevel, 0, 1023, 0, 255);
  analogWrite(blueLedPin, lightIntensity);
}

void senseColor() {
  // Setting red filtered photodiodes to be read
  digitalWrite(S2, LOW);
  digitalWrite(S3, LOW);
  // Reading the output frequency
  frequency = pulseIn(sensorOut, LOW);
  //Remaping the value of the frequency to the RGB Model of 0 to 255
  frequency = map(frequency, 25, 72, 255, 0);
  Serial.print(frequency);//printing RED color frequency  
  Serial.print(",");
  delay(100);

  // Setting Green filtered photodiodes to be read
  digitalWrite(S2, HIGH);
  digitalWrite(S3, HIGH);
  // Reading the output frequency
  frequency = pulseIn(sensorOut, LOW);
  //Remaping the value of the frequency to the RGB Model of 0 to 255
  frequency = map(frequency, 30, 90, 255, 0);
  Serial.print(frequency);//printing GREEN color frequency
  Serial.print(",");
  delay(100);

  // Setting Blue filtered photodiodes to be read
  digitalWrite(S2, LOW);
  digitalWrite(S3, HIGH);
  // Reading the output frequency
  frequency = pulseIn(sensorOut, LOW);
  //Remaping the value of the frequency to the RGB Model of 0 to 255
  frequency = map(frequency, 25, 70, 255, 0);
  Serial.print(frequency);//printing BLUE color frequency
  delay(100);
}
