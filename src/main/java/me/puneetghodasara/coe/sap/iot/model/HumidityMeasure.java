package me.puneetghodasara.coe.sap.iot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import me.puneetghodasara.coe.weather.model.WeatherResponse;
import me.puneetghodasara.coe.weather.model.WeatherResponseReader;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HumidityMeasure extends Measures implements WeatherResponseReader<Measures> {

    private String humidity;

    public HumidityMeasure() {
    }

    public HumidityMeasure(final String humidity) {
        this.humidity = humidity;
    }

    public String getHumidity() {
        return humidity;
    }

    @Override
    public HumidityMeasure from(final WeatherResponse weatherResponse) {
        return new HumidityMeasure(weatherResponse.getHumidity().orElse("No Data"));
    }
}
