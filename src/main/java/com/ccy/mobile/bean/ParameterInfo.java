package com.ccy.mobile.bean;

import com.ccy.bean.Parameter;
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
     * 参数名称
     */
    private String parameterName;


    private Double upper;

    private Double lower;
    /**
     * 单位
     */

    private String suffix;



    /**
     * 当前值
     */
    private double currentValue;

    /**
     * 当前值的采集时间
     */
    private Date currentTime;


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

    public void setParameter(Parameter parameter){
        this.parameterName=parameter.getParameterName();
        this.upper=parameter.getUpper();
        this.lower=parameter.getLower();
        this.suffix=parameter.getSuffix();
    }




    public int getDetectStatus() {
        return detectStatus;
    }


    public int getDeviceStatus() {
        return deviceStatus;
    }

    public void setParameterStatus(ParameterStatus ps) {
        this.detectStatus = ps.getDetectStatus();
        this.deviceStatus = ps.getDeviceStatus();
    }
    public String getParameterName() {
        return parameterName;
    }
    public Double getUpper() {
        return upper;
    }

    public Double getLower() {
        return lower;
    }

    public String getSuffix() {
        return suffix;
    }
    @Override
    public String toString() {
        return "ParameterInfo{" +
                "parameterId=" + parameterId +
                ", parameterName='" + parameterName + '\'' +
                ", upper=" + upper +
                ", lower=" + lower +
                ", suffix='" + suffix + '\'' +
                ", currentValue=" + currentValue +
                ", currentTime=" + currentTime +
                ", detectStatus=" + detectStatus +
                ", deviceStatus=" + deviceStatus +
                '}';
    }
}
