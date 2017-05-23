package com.ccy.mobile.bean;

import com.ccy.bean.ParameterStatus;
import com.ccy.dto.CollectedValue;

import java.util.Date;

/**
 * Created by dsz on 17/5/23.
 */
public class ParameterInfo {

    /**
     * 参数id
     */
    private int parameterId;

    /**
     * 当前值
     */
    private double currentValue;

    /**
     * 当前值的采集时间
     */
    private Date currentTime;

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

    public int getParameterId() {
        return parameterId;
    }

    public void setParameterId(int parameterId) {
        this.parameterId = parameterId;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCollectedValue(CollectedValue cv) {
        this.currentTime = cv.getTime();
        this.currentValue = cv.getValue();
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

    public void setParameterStatus(ParameterStatus ps) {
        this.detectStatus = ps.detectStatus;
        this.deviceStatus = ps.deviceStatus;
        this.measureStatus = ps.measureStatus;
    }

    @Override
    public String toString() {
        return "ParameterInfo{" +
                "parameterId=" + parameterId +
                ", currentValue=" + currentValue +
                ", currentTime=" + currentTime +
                ", measureStatus=" + measureStatus +
                ", detectStatus=" + detectStatus +
                ", deviceStatus=" + deviceStatus +
                '}';
    }
}
