package me.puneetghodasara.coe.sap.iot.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import me.puneetghodasara.coe.sap.iot.model.MeasureFactory;
import me.puneetghodasara.coe.sap.iot.model.Measures;
import me.puneetghodasara.coe.sap.iot.model.SAPIoTPayload;
import me.puneetghodasara.coe.weather.model.WeatherReportType;
import me.puneetghodasara.coe.weather.model.WeatherResponse;

@Component
public class PayloadService {

    @Value("${sap.sensor.temp}")
    private String sensorTemp;
    @Value("${sap.sensor.pressure}")
    private String sensorPressure;
    @Value("${sap.sensor.humidity}")
    private String sensorHumidity;
    @Value("${sap.sensor.wind}")
    private String sensorWind;


    @Value("${sap.capability.temp}")
    private String capabilityTemp;
    @Value("${sap.capability.pressure}")
    private String capabilityPressure;
    @Value("${sap.capability.humidity}")
    private String capabilityHumidity;
    @Value("${sap.capability.wind}")
    private String capabilityWind;

    public List<SAPIoTPayload> getPayload(final WeatherResponse weather){
        final Measures temperatureMeasure = MeasureFactory.getMeasures(WeatherReportType.TEMPERATURE)
                .from(weather);
        final Measures windMeasure = MeasureFactory.getMeasures(WeatherReportType.WIND)
                .from(weather);
        final Measures pressureMeasure = MeasureFactory.getMeasures(WeatherReportType.PRESSURE)
                .from(weather);
        final Measures humidityMeasure = MeasureFactory.getMeasures(WeatherReportType.HUMIDITY)
                .from(weather);

        return Arrays.asList(
                new SAPIoTPayload(sensorTemp, capabilityTemp, temperatureMeasure),
                new SAPIoTPayload(sensorPressure, capabilityPressure, pressureMeasure),
                new SAPIoTPayload(sensorHumidity, capabilityHumidity, humidityMeasure),
                new SAPIoTPayload(sensorWind, capabilityWind, windMeasure)
        );

    }
}
