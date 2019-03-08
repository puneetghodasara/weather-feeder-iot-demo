package me.puneetghodasara.coe.sap.iot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import me.puneetghodasara.coe.weather.model.WeatherResponse;
import me.puneetghodasara.coe.weather.model.WeatherResponseReader;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TemperatureMeasure extends Measures implements WeatherResponseReader<Measures> {

    private String temperature;

    public TemperatureMeasure() {
    }

    public TemperatureMeasure(final String temperature) {
        this.temperature = temperature;
    }

    public String getTemperature() {
        return temperature;
    }

    @Override
    public TemperatureMeasure from(final WeatherResponse weatherResponse) {
        return new TemperatureMeasure(weatherResponse.getTemperature().orElse("No Data"));
    }
}
