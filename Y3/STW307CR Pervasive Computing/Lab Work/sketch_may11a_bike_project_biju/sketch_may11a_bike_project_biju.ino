#include <TinyGPS++.h>
#include "Adafruit_FONA.h"
#include <SoftwareSerial.h>

// GPS Pins
static const int RX_GPS = 5,
                 TX_GPS = 6;
//GMS Pins
static const int VR_FONA = 2,
                 VT_FONA = 3,
                 RST_FONA = 4;
// ADXL335 Pins
static const int xpin = A0,
                 ypin = A1,
                 zpin = A2;

float zero_G = 512.0,//ADC is 0~1023 the zero g output equal to Vs/2
      scale = 102.4; //ADXL335330 Sensitivity is 330mv/g

// GSM & GPS Instances
TinyGPSPlus gps;
Adafruit_FONA fona = Adafruit_FONA(RST_FONA);

SoftwareSerial fonaSS = SoftwareSerial(VT_FONA, VR_FONA);
SoftwareSerial ssGPS = SoftwareSerial(TX_GPS, RX_GPS);
SoftwareSerial *fonaSerial = &fonaSS;

static const uint32_t GPSBaud = 9600;

// Location variables
double valLat = 27.708637;
double valLng = 85.331215;

uint16_t vbat; // Battery level

String dweetThing = "gps_tracker"; // Dweet.io Thing
char url[80];
uint16_t statuscode;
int16_t length;
String request = "www.dweet.io/dweet/for/";

//SMS
uint8_t readline(char *buff, uint8_t maxbuff, uint16_t timeout = 0);
char fonaNotificationBuffer[64];          //for notifications from the FONA
char smsBuffer[1];

boolean trackGPS = false;

void setup() {
  Serial.begin(9600);
  ssGPS.begin(GPSBaud);
  delay(100);
  initGSM();
  initGPRS();

  getBatteryStatus();

  prepareDweetRequest;
  postGPSToDweet();
}

void loop() {
  getBatteryStatus();
  getGPSInfo();
  delay(500);


  //ReceiveSMS();
  //  if (trackGPS == true) {
  //getGPSInfo();
  //    prepareDweetRequest();
  //    postGPSToDweet();
  //  };

  //detectBikeAccident();
}

void getGPSInfo() {
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

void initGSM() {
  while (!Serial);
  Serial.begin(115200);
  fonaSerial->begin(4800);
  if (! fona.begin(*fonaSerial)) {
    Serial.println(F("Couldn't find FONA"));
    while (1);
  }
  Serial.println(F("FONA is OK"));
}

void initGPRS() {
  // fona.enableGPRS(false);
  fona.setGPRSNetworkSettings(F("Web")); //fona.setGPRSNetworkSettings(F("your_APN"), F("your_username"), F("your_password"));
  delay(2000);
  fona.enableGPRS(true);
}

void getBatteryStatus() {
  if (! fona.getBattPercent(&vbat)) {
    Serial.println(F("Failed to read Battery status"));
  } else {
    Serial.print(F("Battery status: ")); Serial.print(vbat); Serial.println(F("%"));
  }
}

void prepareDweetRequest() {
  request += dweetThing;
  request += "?latitude=" + String(valLat);
  request += "&longitude=" + String(valLng);
  request += "&battery=" + String(vbat);
  request.toCharArray(url, request.length());

}

void postGPSToDweet() {
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

void detectBikeAccident() {
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
    getGPSInfo();
    prepareDweetRequest();
    postGPSToDweet();
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

void ReceiveSMS() {
  char* bufPtr = fonaNotificationBuffer; //handy buffer pointer

  if (fona.available()) //any data available from the FONA?
  {
    int slot = 0;//this will be the slot number of the SMS
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
      trackGPS = true;
      Serial.print("slot: "); Serial.println(slot);

      char callerIDbuffer[32];  //we'll store the SMS sender number in here

      // Retrieve SMS sender address/phone number.
      if (! fona.getSMSSender(slot, callerIDbuffer, 31)) {
        Serial.println("Didn't find SMS message in slot!");
      }
      Serial.print(F("FROM: ")); Serial.println(callerIDbuffer);

      // Retrieve SMS value.
      uint16_t smslen;
      if (fona.readSMS(slot, smsBuffer, 250, &smslen)) { // pass in buffer and max len!
        Serial.println(smsBuffer);
      }

      //Send back an automatic response
      Serial.println("Sending reponse...");
      if (!fona.sendSMS(callerIDbuffer, "Hey, I got your text!")) {
        Serial.println(F("Failed"));
      } else {
        Serial.println(F("Sent!"));
      }

      // delete the original msg after it is processed
      //   otherwise, we will fill up all the slots
      //   and then we won't be able to receive SMS anymore
      if (fona.deleteSMS(slot)) {
        Serial.println(F("OK!"));
      } else {
        Serial.print(F("Couldn't delete SMS in slot ")); Serial.println(slot);
        fona.print(F("AT+CMGD=?\r\n"));
      }
    }
  }
}
