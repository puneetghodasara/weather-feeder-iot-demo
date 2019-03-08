package me.puneetghodasara.coe.weather.model;

@FunctionalInterface
public interface WeatherResponseWriter<T> {

    WeatherResponse toWeatherResponse();
}
