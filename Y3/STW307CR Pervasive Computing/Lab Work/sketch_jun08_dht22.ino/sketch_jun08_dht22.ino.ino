#include <DHT.h>

//Pins for Temperature-Humidity Sensor - DHT22
int DHTPIN = 15; //D8
#define DHTTYPE DHT22 // Select DHT sensor model.
DHT dht(DHTPIN, DHTTYPE);

void setup() {
  Serial.begin(9600);
}

void loop() {
  senseTempHumid();
}

void senseTempHumid() {
  float t = dht.readTemperature();
  Serial.println(t);
}
