#include <Arduino.h>
#include <Wire.h>
#include <SPI.h>
#include <DHT.h>
#include <Adafruit_BMP085.h>

#define DHTPIN 2 // DHT 数据引脚
//#define BUZZER 9 // 蜂鸣器 数据引脚

void closebuzzer ();
void tem ();
void over();
void light ();
void print();
void over1();
void bmp();

#define DHTTYPE DHT11 // DHT11
DHT dht(DHTPIN, DHTTYPE);
Adafruit_BMP085 Bmp;
int  LED0_PIN = 3; //电源指示灯
int  LED1_PIN = 5;//电源指示灯
int buzzer_pin = 9;//蜂鸣器引脚
String comdata = "";
String pattern = ""; //表示对应模式
int led1_num = 0;

void setup() {
     pinMode(LED0_PIN, OUTPUT); // 设置 LED 引脚为输出模式
     digitalWrite(LED0_PIN, LOW); // 设置输出低电平
     pinMode(LED1_PIN, OUTPUT); // 设置 LED 引脚为输出模式
     digitalWrite(LED1_PIN, LOW); // 设置输出低电平
     pinMode(buzzer_pin, OUTPUT); // 设置 LED 引脚为输出模式
     digitalWrite(buzzer_pin, LOW); // 设置输出低电平
     analogWrite(buzzer_pin,LOW);

     Serial.begin(9600);
     if (!Bmp.begin()) {
          Serial.println("Could not find a valid BMP085 sensor, check writing!");
     }
     dht.begin();
}

void loop() {
     while (Serial.available() > 0) {
          comdata = Serial.read();
          delay(2);
          Serial.println(pattern);    
     }
     if (comdata.length() > 0){
          Serial.print("Received: ");
          Serial.print(comdata);
          comdata = "";
     }
     if (pattern == "0001")  led1_num = 10;
     else if (pattern == "0010") led1_num = 20;
     else if (pattern == "0100") led1_num = 40;
     else if (pattern == "0101") led1_num = 50;
     else if (pattern == "0110") led1_num = 60;
     else led1_num = 20;

     //默认时间30秒
     for(; led1_num >= 0; led1_num--) {
          //time=time-led1_num;
          light ();

          //if (led1_num%10==0)
          tem();
          bmp();   
          Serial.print("the rest time:");
          Serial.println(led1_num);         

          if (led1_num==0) { 
               over();
          }
     }
}

void tem () {                             //温湿度传感器
      // 读取温湿度
     float h = dht.readHumidity();
     float t = dht.readTemperature();
     // 读取失败处理
     if (isnan(h) || isnan(t)) {
          Serial.println(F("Failed to read from DHT sensor!"));
          return;
     }
 // 计算热指数（利用摄氏温度）
     float hic = dht.computeHeatIndex(t, h, false);
     Serial.print(F("Humidity: "));
     Serial.print(h);
     Serial.print(F("% Temperature: "));
     Serial.print(t);
     Serial.print(F(" Heat index: "));
     Serial.print(hic);
}

void over() {                       //结束时蜂鸣器和常亮灯
     analogWrite(9,50);
     delay(1000); //等待5000毫秒
    //digitalWrite(LED1_PIN, LOW); // 设置输出低电平
    //delay(20)
     Serial.print("time over");
     digitalWrite(LED1_PIN, HIGH); // 设置输出高电平
     delay(2000); // 延时 20000ms         
}

void light () {                     //呼吸灯
    digitalWrite(LED0_PIN, HIGH); // 设置输出高电平
    delay(500); // 延时 500ms
    digitalWrite(LED0_PIN, LOW);  // 设置输出低电平
    delay(500); // 延时 500ms

}

void print () {    //输出函数

   while (Serial.available() > 0){
      comdata += char(Serial.read());
      delay(20);
     }
     if (comdata.length() > 0){
          Serial.print("Received: ");
          Serial.println(comdata);
          comdata = "";
     }
}

void bmp() {
     Serial.print("Pressure = ");
     Serial.print(Bmp.readSealevelPressure());
     Serial.print(" Pa");
};