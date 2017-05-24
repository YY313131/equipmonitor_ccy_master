package com.ccy.mobile.bean;

import java.util.Date;

/**
 * Created by dsz on 17/5/24.
 */
public class AbnormalStatus {

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
     * 出现异常的时间
     */
    private Date abnormalTime;


    public AbnormalStatus(int measureStatus, int detectStatus, int deviceStatus, Date abnormalTime) {
        this.measureStatus = measureStatus;
        this.detectStatus = detectStatus;
        this.deviceStatus = deviceStatus;
        this.abnormalTime = abnormalTime;
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

    public Date getAbnormalTime() {
        return abnormalTime;
    }
}
