#include <ESP8266WiFi.h>
#include <IFTTTWebhook.h>

#define wakePin 16
#define ssid "Softwarica_Coventry"
#define password "softwarica"
#define IFTTT_API_KEY "iqCNZZfNBgFq2QVDlpb7sgvo-3eqWr5Itz1ni_Kr3rD"
#define IFTTT_EVENT_NAME "moisture_low"

void setup() {
  Serial.begin(115200);
  while (!Serial) {
  }
  Serial.println(" ");// print an empty line before and after Button Press
  Serial.println("RESET Button Pressed on NodeMCU");
  Serial.println(" ");// print an empty line

  connectToWifi();
  initWebhook();

  ESP.deepSleep(wakePin);
}

void loop() {
}

void initWebhook() {
  IFTTTWebhook hook(IFTTT_API_KEY, IFTTT_EVENT_NAME);
  hook.trigger();
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
