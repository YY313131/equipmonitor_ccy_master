package com.ccy.bean;

/**
 * Created by dsz on 17/5/23.
 */
public class ParameterStatus {

    /**
     * 当前测量状态
     */
    public int measureStatus;

    /**
     * 当前检测状态
     */
    public int detectStatus;

    /**
     * 当前设备状态
     */
    public int deviceStatus;


    public ParameterStatus(int measureStatus, int detectStatus, int deviceStatus) {
        this.measureStatus = measureStatus;
        this.detectStatus = detectStatus;
        this.deviceStatus = deviceStatus;
    }

    public int getMeasureStatus() {
        return measureStatus;
    }

    public int getDetectStatus() {
        return detectStatus;
    }

    public int getDeviceStatus() {
        return deviceStatus;
    }
}
