#include <TinyGPS++.h>
#include <SoftwareSerial.h>

TinyGPSPlus gps;
static const int RX_GPS = 5, TX_GPS = 6;
SoftwareSerial ssGPS = SoftwareSerial(TX_GPS, RX_GPS);
double valLat = 0, valLng = 0;

void setup() {
  Serial.begin(9600);
  ssGPS.begin(9600);
}

void loop() {
  while (ssGPS.available() > 0) {
    gps.encode(ssGPS.read());
    if (gps.location.isUpdated()) {
      valLat = (gps.location.lat(), 6);
      Serial.print("Latitude = ");
      Serial.print(valLat);

      valLng = (gps.location.lng(), 6);
      Serial.print(" Longitude = ");
      Serial.println(valLng);
    }
  }
}
