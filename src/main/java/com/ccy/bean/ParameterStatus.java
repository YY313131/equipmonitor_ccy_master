package com.ccy.bean;

import java.util.Date;

/**
 * Created by dsz on 17/5/23.
 */
public class ParameterStatus {

    /**
     * 当前测量状态
     */
    private int measureStatus;

    /**
     * 当前检测状态
     */
    private int detectStatus;

    /**
     * 当前设备状态
     */
    private int deviceStatus;
    /**
     * 状态记录的时间
     */
    private Date statusTime;


    public ParameterStatus(Date statusTime) {
        this.statusTime=statusTime;

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

    public void setMeasureStatus(int measureStatus) {
        this.measureStatus = measureStatus;
    }

    public void setDetectStatus(int detectStatus) {
        this.detectStatus = detectStatus;
    }

    public void setDeviceStatus(int deviceStatus) {
        this.deviceStatus = deviceStatus;
    }
}
