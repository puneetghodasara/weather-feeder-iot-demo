package me.puneetghodasara.coe.sap.iot.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface SAPMqttClient extends IMqttClient {

    void publish(MqttMessage message) throws MqttException;
}
