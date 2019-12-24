// Libraries
#include <TinyGPS++.h>
#include "Adafruit_FONA.h"
#include <SoftwareSerial.h>

TinyGPSPlus gps;
// Intializing GPS & GSM Pins
static const int RX_GPS = 5,
                 TX_GPS = 6,
                 FONA_VR = 2,
                 FONA_VT = 3,
                 FONA_RST = 4;

// ADXL335 Pins
static const int xPin = A0,
                 yPin = A1,
                 zPin = A2;

float zero_G = 512.0,//ADC is 0~1023 the zero g output equal to Vs/2
      scale = 102.4; //ADXL335330 Sensitivity is 330mv/g

// Location variables
double valLat = 27.708637;
double valLng = 85.331215;

//SMS Variables
uint8_t readline(char *buff, uint8_t maxbuff, uint16_t timeout = 0);
char fonaNotificationBuffer[64];//for notifications from the FONA
char smsBuffer[40];
char trackToken[] = "track", dontTrackToken[] = "stop";

// Instances
SoftwareSerial fonaSS = SoftwareSerial(FONA_VT, FONA_VR);
SoftwareSerial ssGPS = SoftwareSerial(TX_GPS, RX_GPS);

SoftwareSerial *fonaSerial = &fonaSS;
Adafruit_FONA fona = Adafruit_FONA(FONA_RST);

boolean trackGPS = false;
uint16_t vbat;
String dweetThing = "gps_tracker"; // Dweet.io Thing

void setup() {
  Serial.begin(9600);
  ssGPS.begin(9600);
  //delay(500);

  Serial.println("\n**********INITIALIZING GSM...**********\n");
  initGSM();
  Serial.println("\n**********INITIALIZING GPRS...**********\n");
  initGPRS();
  Serial.println("\n**********INITIALIZING SMS...**********\n");
  initSMS();
}

void loop() {
  checkSMS();
  detectBikeAccident();

  if (trackGPS == true) {
   // getGPSInfo();
    postToDweet();
  }
}

void getGPSInfo() {
  while (ssGPS.available() > 0) {
    gps.encode(ssGPS.read());
    if (gps.location.isUpdated()) {
 
     // valLat = (gps.location.lat(), 6);
      //valLng = (gps.location.lng(), 6);

      Serial.print("Latitude = ");
      Serial.print(String(valLat));
      Serial.print(" Longitude = ");
      Serial.println(String(valLng));
    }
  }
}

void initGSM() {
  while (!Serial);
  fonaSerial->begin(4800);
  if (! fona.begin(*fonaSerial)) {
    Serial.println(F("Couldn't find FONA"));
    while (1);
  }
  Serial.println(F("FONA is OK"));
}

void initGPRS() {
  fona.setGPRSNetworkSettings(F("Web")); //fona.setGPRSNetworkSettings(F("your_APN"), F("your_username"), F("your_password"));
  fona.enableGPRS(true);
}

void getBatteryStatus() {
  if (!fona.getBattPercent(&vbat)) {
    Serial.println(F("Failed to read Batt"));
  } else {
    Serial.print(F("Battery status: ")); Serial.print(vbat); Serial.println(F("%"));
  }
}

void postToDweet() {
  // Prepare request
  String strLat = "27.708637", strLng = "85.331215";
  //strLat = String(valLat);
  //strLng = String(valLng);

  //getBatteryStatus();
  uint16_t statuscode;
  int16_t length;
  char url[90];
  String request = "www.dweet.io/dweet/for/";
  request += dweetThing;
  request += "?latitude=" + strLat;
  request += "&longitude=" + strLng;
  request += "&battery=" + String(vbat);
  request.toCharArray(url, request.length() + 1);

  Serial.println(url);
  // Send location to Dweet.io
  if (!fona.HTTP_GET_start(url, &statuscode, (uint16_t *)&length)) {
    Serial.println("Failed!");
  }
  while (length > 0) {
    while (fona.available()) {
      char c = fona.read();
      // Serial.write is too slow, we'll write directly to Serial register!
#if defined(__AVR_ATmega328P__) || defined(__AVR_ATmega168__)
      loop_until_bit_is_set(UCSR0A, UDRE0); /* Wait until data register empty. */
      UDR0 = c;
#else
      Serial.write(c);
#endif
      length--;
    }
  }
  fona.HTTP_GET_end();
}

void initSMS() {
  while (!Serial);
  Serial.println(F("FONA SMS caller ID test"));
  Serial.println(F("Initializing....(May take 3 seconds)"));

  // make it slow so its easy to read!
  fonaSerial->begin(4800);
  if (! fona.begin(*fonaSerial)) {
    Serial.println(F("Couldn't find FONA"));
    while (1);
  }
  Serial.println(F("FONA is OK"));

  // Print SIM card IMEI number.
  char imei[16] = {0}; // MUST use a 16 character buffer for IMEI!
  uint8_t imeiLen = fona.getIMEI(imei);
  if (imeiLen > 0) {
    Serial.print("SIM card IMEI: "); Serial.println(imei);
  }

  fonaSerial->print("AT+CNMI=2,1\r\n");  //set up the FONA to send a +CMTI notification when an SMS is received

  Serial.println("FONA Ready");
}

void detectBikeAccident() {
  int x = analogRead(xPin);
  int y = analogRead(yPin);
  int z = analogRead(zPin);

  //330 * 1024/3.3/1000
  float _x  = ((float)x - 331.5) / 65 * 9.8;
  float _y = ((float)y - 329.5) / 68.5 * 9.8;
  float _z = ((float)z - 340) / 68 * 9.8;

  Serial.print(_x);
  Serial.print("\t");
  Serial.print(_y);
  Serial.print("\t");
  Serial.print(_z);
  Serial.print("\n");

  if (isBikeUpTurn(_x, _y, _z) || isBikeLeftFlip(_x, _y, _z) || isBikeRightFlip(_x, _y, _z)) {
    Serial.println("\n**********Accident Detected!**********\n");
    //getGPSInfo();
    postToDweet();
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

void checkSMS() {
  char* bufPtr = fonaNotificationBuffer;    //handy buffer pointer
  if (fona.available())      //any data available from the FONA?
  {
    int slot = 0;            //this will be the slot number of the SMS
    int charCount = 0;
    //Read the notification into fonaInBuffer
    do  {
      *bufPtr = fona.read();
      Serial.write(*bufPtr);
      delay(1);
    } while ((*bufPtr++ != '\n') && (fona.available()) && (++charCount < (sizeof(fonaNotificationBuffer) - 1)));

    //Add a terminal NULL to the notification string
    *bufPtr = 0;

    //Scan the notification string for an SMS received notification.
    //  If it's an SMS message, we'll get the slot number in 'slot'
    if (1 == sscanf(fonaNotificationBuffer, "+CMTI: " FONA_PREF_SMS_STORAGE ",%d", &slot)) {
      Serial.print("slot: "); Serial.println(slot);

      char callerIDbuffer[32];  //Storing the SMS sender number in here

      // Retrieve SMS sender address/phone number.
      if (! fona.getSMSSender(slot, callerIDbuffer, 31)) {
        Serial.println("Didn't find SMS message in slot!");
      }
      Serial.print(F("FROM: ")); Serial.println(callerIDbuffer);

      // Retrieve SMS value.
      uint16_t smslen;
      if (fona.readSMS(slot, smsBuffer, 250, &smslen)) { // pass in buffer and max len!
        Serial.println(smsBuffer);
        if (strncmp(smsBuffer, trackToken, sizeof(smsBuffer)) == 0) { // If track request received
          Serial.println("Received Track Request.");
          //Send back an automatic response
          Serial.println("Sending reponse...");
          if (!fona.sendSMS(callerIDbuffer, "Tracking GPS...Check your freeboard.io dashboard.")) {         
            Serial.println(F("Failed"));
          } else {
            Serial.println(F("Sent!"));
          }
          trackGPS = true;
        } else if (strncmp(smsBuffer, dontTrackToken, sizeof(smsBuffer)) == 0) { // If stop request received
          trackGPS = false;
        }
        // delete the original msg after it is processed
        // otherwise, we will fill up all the slots
        // and then we won't be able to receive SMS anymore
        if (fona.deleteSMS(slot)) {
          Serial.println(F("OK!"));
        } else {
          Serial.print(F("Couldn't delete SMS in slot ")); Serial.println(slot);
          fona.print(F("AT+CMGD=?\r\n"));
        }
      }
    }
  }
}
