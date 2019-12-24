#include <TinyGPS++.h>
#include <SoftwareSerial.h>

TinyGPSPlus gps;

static const int RXPinGPS = 5, TXPinGPS = 6;
static const uint32_t GPSBaud = 9600;
//
SoftwareSerial ssGPS(TXPinGPS, RXPinGPS);//Serial connection - GPS module

// ADXL335 Pins
static const int xPin = A0,
                 yPin = A1,
                 zPin = A2;

void setup() {
  Serial.begin(9600);
  ssGPS.begin(9600);//Setting the baud rate of GPS Module
  delay(100);
}

void loop() {
  delay(1000);
  detectBikeAccident();
  getGPSInfo();
}

void getGPSInfo() {
 // while (ssGPS.available() > 0) {
    gps.encode(ssGPS.read());
    if (gps.location.isUpdated()) {
      Serial.print("Latitude = ");
      Serial.print(gps.location.lat(), 6);
      Serial.print(" Longitude = ");
      Serial.println(gps.location.lng(), 6);
    }
 // }
}

void detectBikeAccident() {
  int x = analogRead(xPin);
  int y = analogRead(yPin);
  int z = analogRead(zPin);

  //330 * 1024/3.3/1000
  float _x  = ((float)x - 331.5) / 65 * 9.8;
  float _y = ((float)y - 329.5) / 68.5 * 9.8;
  float _z = ((float)z - 340) / 68 * 9.8;

  //delay(1000);
  Serial.print(_x);
  Serial.print("\t");
  Serial.print(_y);
  Serial.print("\t");
  Serial.print(_z);
  Serial.print("\n");

  if (isBikeUpTurn(_x, _y, _z) || isBikeLeftFlip(_x, _y, _z) || isBikeRightFlip(_x, _y, _z)) {
    Serial.println("\n**********Accident Detected!**********\n");
    getGPSInfo();
    //postToDweet();
  }
}

boolean isBikeUpTurn(float _x, float _y, float _z) {
  boolean status = false;
  if (_x > 1.00 && _y > 1.20 && _z > 10.50) {
    status = true;
    Serial.println("\n**********Bike upturned!**********\n");
  }
  return status;
}

boolean isBikeRightFlip(float _x, float _y, float _z) {
  boolean status = false;
  if (_x > 11.00 && _y > 6.00 && _z > 3.00) {
    status = true;
    Serial.print("\n**********Bike flipped to the right!**********\n");
  }
  return status;
}

boolean isBikeLeftFlip(float _x, float _y, float _z) {
  boolean status = false;
  if (_x < 1.00 && _y < 10.00 && _z > -3.00) {
    status = true;
    Serial.print("\n**********Bike flipped to the left!**********\n");
  }
  return status;
}
