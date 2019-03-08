package me.puneetghodasara.coe.owm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

import me.puneetghodasara.coe.weather.model.WeatherResponse;
import me.puneetghodasara.coe.weather.model.WeatherResponseWriter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OWMResponse implements WeatherResponseWriter<OWMResponse> {

    @JsonProperty("main")
    private Weather weather;
    private Wind wind;

    public OWMResponse() {
    }

    public Weather getWeather() {
        return weather;
    }

    public Wind getWind() {
        return wind;
    }

    @Override
    public String toString() {
        return "OWMResponse{" +
                "coe=" + weather +
                ", wind=" + wind +
                '}';
    }

    @Override
    public WeatherResponse toWeatherResponse() {
        return new WeatherResponse(String.valueOf(this.weather.getTemp()),
                String.valueOf(this.getWeather().getTemp_min()),
                String.valueOf(this.getWeather().getTemp_max()),
                String.valueOf(this.getWeather().getPressure()),
                String.valueOf(this.getWeather().getHumidity()),
                String.valueOf(this.getWind().getSpeed()),
                Instant.now().toEpochMilli()
        );
    }
}
