package com.ccy.mobile.bean;

import java.util.List;

/**
 * Created by dsz on 17/5/24.
 */
public class HistoryAbnormalValue {
    /**
     * 传感器id
     */

    private int parameterId;
    /**
     * 传感器名称
     */

    private int parameterName;
    /**
     * 异常状态列表
     */

    private List<AbnormalStatus> abnormalValueList;

    public HistoryAbnormalValue(int parameterId, int parameterName, List<AbnormalStatus> abnormalValueList) {
        this.parameterId = parameterId;
        this.parameterName = parameterName;
        this.abnormalValueList = abnormalValueList;
    }

    public int getParameterId() {
        return parameterId;
    }

    public int getParameterName() {
        return parameterName;
    }

    public List<AbnormalStatus> getAbnormalValueList() {
        return abnormalValueList;
    }
}
