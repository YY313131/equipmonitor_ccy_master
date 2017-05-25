package com.ccy.mobile.bean;

import com.ccy.bean.ParameterStatus;

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
     * 异常状态列表
     */

    private List<ParameterStatus> abnormalValueList;

    public HistoryAbnormalValue(int parameterId, List<ParameterStatus> abnormalValueList) {
        this.parameterId = parameterId;

        this.abnormalValueList = abnormalValueList;
    }

    public int getParameterId() {
        return parameterId;
    }



    public List<ParameterStatus> getAbnormalValueList() {
        return abnormalValueList;
    }
}
