package me.puneetghodasara.coe.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Optional;

/**
 * Generic coe response should contain one or more </br>
 * of the followings
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private String temperature;
    private String temperatureMin;
    private String temperatureMax;
    private String pressure;
    private String humidity;
    private String wind;
    private Long timestamp;

    public WeatherResponse(final String temperature,
                           final String temperatureMin,
                           final String temperatureMax,
                           final String pressure,
                           final String humidity,
                           final String wind,
                           final long timestamp) {
        this.temperature = temperature;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind = wind;
        this.timestamp = timestamp;
    }

    public Optional<String> getTemperature() {
        return Optional.ofNullable(temperature);
    }

    public Optional<String> getTemperatureMin() {
        return Optional.ofNullable(temperatureMin);
    }

    public Optional<String> getTemperatureMax() {
        return Optional.ofNullable(temperatureMax);
    }

    public Optional<String> getPressure() {
        return Optional.ofNullable(pressure);
    }

    public Optional<String> getHumidity() {
        return Optional.ofNullable(humidity);
    }

    public Optional<String> getWind() {
        return Optional.ofNullable(wind);
    }

    public Optional<Long> getTimestamp() {
        return Optional.ofNullable(timestamp);
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "temperature='" + temperature + '\'' +
                ", temperatureMin='" + temperatureMin + '\'' +
                ", temperatureMax='" + temperatureMax + '\'' +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                ", wind='" + wind + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
