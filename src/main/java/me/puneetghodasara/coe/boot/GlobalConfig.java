package me.puneetghodasara.coe.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sap")
public class GlobalConfig {

    private String host;
    private String deviceId;
    private Keystore keystore;

    public static class Keystore {
        private String passphrase;
        private String filename;

        public String getPassphrase() {
            return passphrase;
        }

        public Keystore setPassphrase(final String passphrase) {
            this.passphrase = passphrase;
            return this;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(final String filename) {
            this.filename = filename;
        }
    }

    public String getHost() {
        return host;
    }

    public GlobalConfig setHost(final String host) {
        this.host = host;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public GlobalConfig setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public Keystore getKeystore() {
        return keystore;
    }

    public GlobalConfig setKeystore(final Keystore keystore) {
        this.keystore = keystore;
        return this;
    }
}
