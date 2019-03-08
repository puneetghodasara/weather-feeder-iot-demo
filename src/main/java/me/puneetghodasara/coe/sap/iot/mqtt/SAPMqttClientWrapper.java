package me.puneetghodasara.coe.sap.iot.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import me.puneetghodasara.coe.boot.GlobalConfig;

@Component
public class SAPMqttClientWrapper extends MqttClient implements SAPMqttClient {

    private static final Logger logger = LoggerFactory.getLogger(SAPMqttClientWrapper.class);

    private String topic;
    private SSLContext sslContext;

    public SAPMqttClientWrapper(GlobalConfig globalConfig) throws Exception {
        super(globalConfig.getHost(), globalConfig.getDeviceId());
        this.topic = "measures/" + globalConfig.getDeviceId();
        // client key
        KeyStore ks = KeyStore.getInstance("PKCS12");
        final File file = ResourceUtils.getFile(globalConfig.getKeystore().getFilename());
        logger.info("(SAPMqttClientWrapper) file.getAbsolutePath() = " + file.getAbsolutePath());
        final String passphrase = globalConfig.getKeystore().getPassphrase();
        ks.load(new FileInputStream(file), passphrase.toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, passphrase.toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init((KeyStore) null);

        sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
    }

    @Override
    public void connect() throws MqttException {

        final MqttConnectOptions options = new MqttConnectOptions();
        options.setSocketFactory(sslContext.getSocketFactory());
        options.setCleanSession(true);
        super.connect(options);
    }

    @Override
    public void publish(final MqttMessage message) throws MqttException {
        super.publish(topic, message);
    }
}
