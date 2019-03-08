package me.puneetghodasara.coe.sap.iot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import me.puneetghodasara.coe.weather.model.WeatherResponse;
import me.puneetghodasara.coe.weather.model.WeatherResponseReader;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PressureMeasure extends Measures implements WeatherResponseReader<Measures> {

    private String pressure;

    public PressureMeasure() {
    }

    public PressureMeasure(final String pressure) {
        this.pressure = pressure;
    }

    public String getPressure() {
        return pressure;
    }

    @Override
    public PressureMeasure from(final WeatherResponse weatherResponse) {
        return new PressureMeasure(weatherResponse.getPressure().orElse("No Data"));
    }
}
