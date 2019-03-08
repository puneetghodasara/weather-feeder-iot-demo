package me.puneetghodasara.coe.weather.model;

@FunctionalInterface
public interface WeatherResponseReader<T> {

    T from(WeatherResponse weatherResponse);
}
