package com.ccy.mobile.bean;

import com.ccy.bean.ParameterStatus;
import com.ccy.dto.CollectedValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dsz on 17/5/23.
 */
public class SubsystemInfo {

    /**
     * 系统编号
     */
    private int subsystemId;

    /**
     * 设备信息列表
     */
    private Map<Integer, ParameterInfo> parameterInfos;


    public SubsystemInfo(int subsystemId, Map<Integer, CollectedValue> cvMap) {
        this.subsystemId = subsystemId;
        setParameterValues(cvMap);
    }

    public int getSubsystemId() {
        return subsystemId;
    }

    public void setSubsystemId(int subsystemId) {
        this.subsystemId = subsystemId;
    }

    public Map<Integer, ParameterInfo> getParameterInfos() {
        return parameterInfos;
    }

    public void setParameterValues(Map<Integer, CollectedValue> cvMap) {
        if (cvMap == null)
            throw new NullPointerException("cvMap");

        if (parameterInfos == null)
            parameterInfos = new HashMap<Integer, ParameterInfo>(32);

        for (Map.Entry<Integer, CollectedValue> entry : cvMap.entrySet()) {
            ParameterInfo parameterInfo;
            if (parameterInfos.containsKey(entry.getKey())) {
                parameterInfo = parameterInfos.get(entry.getKey());
            } else {
                parameterInfo = new ParameterInfo();
                parameterInfos.put(entry.getKey(), parameterInfo);
            }
            parameterInfo.setParameterId(entry.getKey());
            parameterInfo.setCollectedValue(entry.getValue());
        }
    }

    public void setParameterStatus(Map<Integer, ParameterStatus> psMap) {
        if (psMap == null)
            throw new NullPointerException("psMap");

        if (parameterInfos == null)
            parameterInfos = new HashMap<Integer, ParameterInfo>(32);

        for (Map.Entry<Integer, ParameterStatus> entry : psMap.entrySet()) {
            ParameterInfo parameterInfo;
            if (parameterInfos.containsKey(entry.getKey())) {
                parameterInfo = parameterInfos.get(entry.getKey());
            } else {
                parameterInfo = new ParameterInfo();
                parameterInfos.put(entry.getKey(), parameterInfo);
            }
            parameterInfo.setParameterId(entry.getKey());
            parameterInfo.setParameterStatus(entry.getValue());
        }

    }
}
