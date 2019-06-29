package model;

import java.util.ArrayList;
import java.util.Observable;

public class Information extends Observable {
    private int humidity = 0;
    private float temperature = 0;
    private boolean possible = false;
    private boolean donneesExiste = false;
    // Contient toutes les informations


    public boolean getDonneesExiste() {
        return this.donneesExiste;
    }

    public void setDonneesExiste(boolean donneesExiste) {
        this.donneesExiste = donneesExiste;
    }

    public void setHumidity(String humidity) {
        this.humidity = Integer.parseInt(humidity);
        notifyObservers();
    }

    public int getHumidity() {
        return humidity;
    }


    public void setTemperature(String temperature) {
        this.temperature = Float.valueOf(temperature);
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public boolean getPossible() {
        return this.possible;
    }

    public Observable getObservable() {
        return this;
    }

}
