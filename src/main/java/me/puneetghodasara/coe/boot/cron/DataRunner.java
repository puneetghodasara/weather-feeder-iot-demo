package me.puneetghodasara.coe.boot.cron;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.annotation.Resource;

import me.puneetghodasara.coe.sap.iot.SAPIoTGatewayService;
import me.puneetghodasara.coe.sap.iot.model.SAPIoTPayload;
import me.puneetghodasara.coe.sap.iot.util.PayloadService;
import me.puneetghodasara.coe.weather.api.WeatherService;
import me.puneetghodasara.coe.weather.model.WeatherResponse;

@Component
public class DataRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataRunner.class);

    @Resource
    private WeatherService weatherService;

    @Resource
    private PayloadService payloadService;

    @Resource
    private SAPIoTGatewayService gatewayService;

    @Scheduled(cron = "${cron.expression}")
    public void scheduleFixedRateTask() {
        final WeatherResponse weather = weatherService.getWeather();
        logger.info("weather = " + weather);

        final List<SAPIoTPayload> payload = payloadService.getPayload(weather);

        try {
            gatewayService.send(payload);
        } catch (MqttException e) {
            logger.error("(scheduleFixedRateTask) Error sending payload " + e.getMessage());
        }

    }

}
