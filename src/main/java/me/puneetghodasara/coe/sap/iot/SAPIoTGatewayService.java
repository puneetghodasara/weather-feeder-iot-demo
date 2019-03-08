package me.puneetghodasara.coe.sap.iot;

import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.List;

import me.puneetghodasara.coe.sap.iot.model.SAPIoTPayload;

public interface SAPIoTGatewayService {

    void send(final List<SAPIoTPayload> sapIoTPayload) throws MqttException;

    void send(final SAPIoTPayload sapIoTPayload) throws MqttException;
}
