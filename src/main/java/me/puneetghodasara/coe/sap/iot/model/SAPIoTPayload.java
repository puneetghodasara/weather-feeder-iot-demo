package me.puneetghodasara.coe.sap.iot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SAPIoTPayload {

    @JsonProperty("sensorAlternateId")
    private String sensor;
    @JsonProperty("capabilityAlternateId")
    private String capability;
    private Measures measures;

    public SAPIoTPayload() {
    }

    public SAPIoTPayload(final String sensor, final String capability, final Measures measures) {
        this.sensor = sensor;
        this.capability = capability;
        this.measures = measures;
    }

    public String getSensor() {
        return sensor;
    }

    public String getCapability() {
        return capability;
    }

    public Measures getMeasures() {
        return measures;
    }

}
