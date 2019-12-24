#define LEDFLASHER 3
#define ALARMSOUNDER 5
#define ALARMSWITCH 8
int i = 0;
int val = LOW;
int pre_val = LOW;
int state = 1;
void setup()
{
  pinMode(LEDFLASHER, OUTPUT);
  pinMode(ALARMSOUNDER, OUTPUT);
  pinMode(ALARMSWITCH, INPUT);
}
void loop()
{
  state = digitalRead(ALARMSWITCH);
  if (state == 1)
  {
    for (i = 0; i < 255; i = i + 2)
    {
      analogWrite(LEDFLASHER, i);
      analogWrite(ALARMSOUNDER, i);
      delay(10);
    }
    for (i = 255; i > 1; i = i - 2)
    {
      analogWrite(LEDFLASHER, i);
      analogWrite(ALARMSOUNDER, i);
      delay(5);
    }
    for (i = 1; i <= 10; i++)
    {
      analogWrite(LEDFLASHER, 255);
      analogWrite(ALARMSOUNDER, 200);
      delay(100);
      analogWrite(LEDFLASHER, 0);
      analogWrite(ALARMSOUNDER, 25);
      delay(100);
    }
  }
  else
  {
    analogWrite(ALARMSOUNDER, 0);
    analogWrite(LEDFLASHER, 0);
  }
  pre_val = val;
}
