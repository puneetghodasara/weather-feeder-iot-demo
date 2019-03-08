package me.puneetghodasara.coe.owm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

    private Float speed;
    private Float deg;

    public Wind() {
    }

    public Float getSpeed() {
        return speed;
    }

    public Float getDeg() {
        return deg;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}
