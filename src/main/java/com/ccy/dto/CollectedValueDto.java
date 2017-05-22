package com.ccy.dto;



/**
 * Created by caihanbin on 2017/4/30.
 */
public class CollectedValueDto {
    private String sensorId;
    private double value;
    private String currentTime;
    private String state;

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    @Override
    public String toString() {
        return "CollectedValueDto{" +
                "sensorId='" + sensorId + '\'' +
                ", value=" + value +
                ", currentTime=" + currentTime +
                ", state='" + state + '\'' +
                '}';
    }
}
