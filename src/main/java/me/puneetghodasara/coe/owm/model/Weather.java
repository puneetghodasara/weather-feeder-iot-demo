package me.puneetghodasara.coe.owm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private Float temp;
    private Float pressure;
    private Float humidity;
    private Float temp_min;
    private Float temp_max;

    public Weather() {
    }

    public Float getTemp() {
        return temp;
    }

    public Float getPressure() {
        return pressure;
    }

    public Float getHumidity() {
        return humidity;
    }

    public Float getTemp_min() {
        return temp_min;
    }

    public Float getTemp_max() {
        return temp_max;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                '}';
    }
}
