package me.puneetghodasara.coe.sap.iot.model;

import me.puneetghodasara.coe.weather.model.WeatherReportType;
import me.puneetghodasara.coe.weather.model.WeatherResponseReader;

public class MeasureFactory {

    public static WeatherResponseReader<Measures> getMeasures(final WeatherReportType type) {

        switch (type) {
            case TEMPERATURE:
                return new TemperatureMeasure();
            case PRESSURE:
                return new PressureMeasure();
            case WIND:
                return new WindMeasure();
            case HUMIDITY:
                return new HumidityMeasure();
            default:
                // Default is Temp
                return new TemperatureMeasure();

        }
    }
}
