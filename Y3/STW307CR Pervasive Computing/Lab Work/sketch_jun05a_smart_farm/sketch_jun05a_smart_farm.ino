#include <ESP8266WiFi.h>
#include <BlynkSimpleEsp8266.h>

//WiFi
const char auth[] = "12b7c0c3704648f3acde647a5bcb2c40"; //Blynk
const char ssid[] = "romisha";
const char password[] = "romishathapa";

//Serial read (from UNO)
short terminator = 88; // Message Terminator ASCII for 'X'
short portIndex = 0;  // select the com port, 0 is the first port

void setup() {
  Serial.begin(115200);
  //WiFi & Blynk initialization
  connectToWifi();
  Blynk.begin(auth, ssid, password);
}

void loop() {
  delay(1000);
  String message = Serial.readStringUntil(terminator); // read serial data  
    Serial.println(message.length());
    Serial.println(message);
  if (message.length() > 40) {
    Serial.print("Length; ");
    Serial.print(message.length());
    Serial.println(getStringPartByNr(message, ',', 0));
    Serial.println(getStringPartByNr(message, ',', 1));
    Serial.println(getStringPartByNr(message, ',', 2));
    Serial.println(getStringPartByNr(message, ',', 3));
    Serial.println(getStringPartByNr(message, ',', 4));
    Serial.println(getStringPartByNr(message, ',', 5));

    int r = getStringPartByNr(message, ',', 6).toInt();
    int g = getStringPartByNr(message, ',', 7).toInt();
    int b = getStringPartByNr(message, ',', 8).toInt();

    Serial.println(r);
    Serial.println(g);
    Serial.println(b);

    //Check RGB for NPK level

    //Serial.println(message);
    Blynk.virtualWrite(V1, getStringPartByNr(message, ',', 3)); //Humidity
    Blynk.virtualWrite(V2, getStringPartByNr(message, ',', 4)); //Temperature
    Blynk.virtualWrite(V3, getStringPartByNr(message, ',', 0)); //Moisture

    Blynk.virtualWrite(V10, 1, getStringPartByNr(message, ',', 1).toFloat(), getStringPartByNr(message, ',', 2).toFloat(), "Romisha-Biju Field"); //GPS Coordinates
  } else {
    Serial.println("Data broken.");
  }
}

String getStringPartByNr(String data, char separator, int index) {
  // spliting a string and return the part nr index
  // split by separator
  int stringData = 0;        //variable to count data part nr
  String dataPart = "";      //variable to hole the return text

  for (int i = 0; i < data.length() - 1; i++) { //Walk through the text one letter at a time
    if (data[i] == separator) {
      //Count the number of times separator character appears in the text
      stringData++;
    } else if (stringData == index) {
      //get the text when separator is the rignt one
      dataPart.concat(data[i]);
    } else if (stringData > index) {
      //return text and stop if the next separator appears - to save CPU-time
      return dataPart;
      break;
    }
  }
  //return text if this is the last part
  return dataPart;
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
