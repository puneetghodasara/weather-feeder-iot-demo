package me.puneetghodasara.coe.sap.iot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import me.puneetghodasara.coe.weather.model.WeatherResponse;
import me.puneetghodasara.coe.weather.model.WeatherResponseReader;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WindMeasure extends Measures implements WeatherResponseReader<Measures> {

    @JsonProperty("speed")
    private String wind;
    @JsonProperty("direction")
    private String direction;


    public WindMeasure() {
    }

    public WindMeasure(final String wind) {
        this.wind = wind;
    }

    public String getWind() {
        return wind;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public WindMeasure from(final WeatherResponse weatherResponse) {
        return new WindMeasure(weatherResponse.getWind().orElse("No Data"));
    }
}
