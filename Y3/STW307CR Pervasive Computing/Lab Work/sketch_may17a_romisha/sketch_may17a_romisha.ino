#include <ArduinoJson.h>
#include <ESP8266HTTPClient.h>
#include <ESP8266WiFi.h>

StaticJsonBuffer<300> JSONbuffer;
JsonObject& JSONencoder = JSONbuffer.createObject();

const int httpPort = 80;

const char* ssid = "Softwarica_Coventry";
const char* password = "softwarica";
const char* host = "maker.ifttt.com";
const char* apiKey = "iqCNZZfNBgFq2QVDlpb7sgvo-3eqWr5Itz1ni_Kr3rD";

String moistureStatus;

const int pinSensor = 0;
const int pinMotor = 5;
int moistureValue;

void setup () {
  pinMode(pinSensor, INPUT);
  pinMode(pinMotor, OUTPUT);

  Serial.begin(115200);
  delay(100);
  //connectToWifi();
}

void loop () {
  delay(1000);
  moistureValue = analogRead(pinSensor);
  Serial.println(moistureValue);

  if (analogRead(pinSensor) > 900) {//If soil is dry
    Serial.println("Moisture LOW");   
    digitalWrite(pinMotor, LOW);
    delay(5000);
    digitalWrite(pinMotor, HIGH);
    if (analogRead(pinSensor) < 900) {
      moistureStatus = " HIGH";
     // postToIFTT();
      Serial.println("Moisture restored");
    }
  }
}

void postToIFTTT() {


  String data = "[{\"value1\":\" LOW\"}]";

  if (WiFi.status() == WL_CONNECTED) {

    StaticJsonBuffer<300> JSONbuffer;   //Declaring static JSON buffer
    JsonObject& JSONencoder = JSONbuffer.createObject();

    JSONencoder["value1"] = "LOW";

    char JSONmessageBuffer[300];
    JSONencoder.prettyPrintTo(JSONmessageBuffer, sizeof(JSONmessageBuffer));
    Serial.println(JSONmessageBuffer);

    HTTPClient http;
    http.begin("http://maker.ifttt.com/trigger/moisture_low/with/key/iqCNZZfNBgFq2QVDlpb7sgvo-3eqWr5Itz1ni_Kr3rD");      //Specify request destination
    http.addHeader("Content-Type", "application/json");  //Specify content-type header

    int httpCode = http.POST(JSONmessageBuffer);   //Send the request
    String payload = http.getString(); //Get the response payload

    Serial.println(httpCode); //Print HTTP return code
    Serial.println(payload); //Print request response payload

    http.end();  //Close connection

  } else {
    Serial.println("Error in WiFi connection");
  }
}

void connectToWifi() {
  Serial.print("Connecting to: SSID NAME"); //uncomment next line to show SSID name
  //Serial.print(ssid);
  WiFi.begin(ssid, password);
  Serial.println(" ");// print an empty line
  Serial.print("Attempting to connect: ");

  //try to connect for 10 seconds
  int i = 10;
  while (WiFi.status() != WL_CONNECTED && i >= 0) {
    delay(1000);
    Serial.print(i);
    Serial.print(", ");
    i--;
  }
  Serial.println(" ");// print an empty line

  //print connection result
  if (WiFi.status() == WL_CONNECTED) {
    Serial.print("Connected.");
    Serial.println(" ");// print an empty line
    Serial.print("NodeMCU ip address: ");
    Serial.println(WiFi.localIP());
  }
  else {
    Serial.println("Connection failed - check your credentials or connection");
  }
}
