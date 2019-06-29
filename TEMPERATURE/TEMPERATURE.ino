#include "DHT.h"   // Librairie des capteurs DHT
#define DHTPIN 2    // Changer le pin sur lequel est branché le DHT
#define DHTTYPE DHT22       // DHT 22  (AM2302)

DHT dht(DHTPIN, DHTTYPE); 



void setup() {
  Serial.begin(9600);
  dht.begin();
}

void loop() {
  // Délai de 2 secondes entre chaque mesure. La lecture prend 250 millisecondes
  delay(2000);

  // Lecture du taux d'humidité
  int h = dht.readHumidity();
  // Lecture de la température en Celcius
  float t = dht.readTemperature();
  // Pour lire la température en Fahrenheit
  float f = dht.readTemperature(true);
  
  // Stop le programme et renvoie un message d'erreur si le capteur ne renvoie aucune mesure
  if (isnan(h) || isnan(t) || isnan(f)) {
    Serial.println("Echec de lecture !");
    return;
  }

  // Calcul la température ressentie. Le calcul est effectué à partir de la température en Fahrenheit
  // On fait la conversion en Celcius
  float hi = dht.computeHeatIndex(f, h);

  String thisH = String(h);
  String thisT = String(t);
  String msg = thisH + String("/") + thisT + String("/THEO#");
  Serial.println(msg);
}
