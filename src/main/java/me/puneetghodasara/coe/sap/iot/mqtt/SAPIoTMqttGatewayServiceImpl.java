package me.puneetghodasara.coe.sap.iot.mqtt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import me.puneetghodasara.coe.sap.iot.model.SAPIoTPayload;
import me.puneetghodasara.coe.sap.iot.SAPIoTGatewayService;

@Component
public class SAPIoTMqttGatewayServiceImpl implements SAPIoTGatewayService {

    private static final Logger logger = LoggerFactory.getLogger(SAPIoTMqttGatewayServiceImpl.class);

    @Resource
    private SAPMqttClient mqttClient;


    @Override
    public void send(final List<SAPIoTPayload> sapIoTPayload) throws MqttException {

        final String jsonPayload;
        try {
            jsonPayload = new ObjectMapper().writer().writeValueAsString(sapIoTPayload);
        } catch (JsonProcessingException e) {
            logger.error("(send) Exception to serialize to JSON {}", e.getMessage());
            return;
        }
        doSend(jsonPayload);
    }

    @Override
    public void send(final SAPIoTPayload sapIoTPayload) throws MqttException {
        final String jsonPayload;
        try {
            jsonPayload = new ObjectMapper().writer().writeValueAsString(sapIoTPayload);
        } catch (JsonProcessingException e) {
            logger.error("(send) Exception to serialize to JSON {}", e.getMessage());
            return;
        }
        doSend(jsonPayload);
    }

    private void doSend(final String jsonPayload) throws MqttException {
        final String broker = mqttClient.getServerURI();

        if (!mqttClient.isConnected()) {
            logger.info("Connecting from broker: " + broker);
            this.connect();
            logger.info("Connected");
        }

        logger.info("(send) jsonPayload = " + jsonPayload);

        MqttMessage message = new MqttMessage(jsonPayload.getBytes());
        message.setQos(2);
        mqttClient.publish(message);

    }

    private void connect() throws MqttException {
        mqttClient.connect();
    }

    @PreDestroy
    public void disconnect() throws MqttException {
        mqttClient.disconnect();
    }

}
