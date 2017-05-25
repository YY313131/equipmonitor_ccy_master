package com.ccy.mobile.bean;

import com.ccy.bean.Parameter;
import com.ccy.bean.ParameterStatus;
import com.ccy.dto.CollectedValue;

import java.util.*;

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

    private List<ParameterInfo> parameterInfos;

    public SubsystemInfo(int subsystemId, Map<Integer,
                         CollectedValue> cvMap,
                         Map<Integer, ParameterStatus> psMap,
                         List<Parameter>pnList
    ) {
        this.subsystemId = subsystemId;
        setParameterValues(cvMap,psMap,pnList);
    }

    public int getSubsystemId() {
        return subsystemId;
    }

    public void setSubsystemId(int subsystemId) {
        this.subsystemId = subsystemId;
    }

    public List<ParameterInfo> getParameterInfos() {
        return parameterInfos;
    }

    public void setParameterValues(Map<Integer, CollectedValue> cvMap,
                                   Map<Integer, ParameterStatus> psMap,
                                   List<Parameter> pnList
    ) {

        Map<Integer, ParameterInfo> pMap = new HashMap<Integer, ParameterInfo>(32);
        if (cvMap != null) {
            for (Map.Entry<Integer, CollectedValue> entry : cvMap.entrySet()) {
                ParameterInfo parameterInfo;
                if (pMap.containsKey(entry.getKey())) {
                    parameterInfo = pMap.get(entry.getKey());
                } else {
                    parameterInfo = new ParameterInfo();
                    pMap.put(entry.getKey(), parameterInfo);
                }
                parameterInfo.setParameterId(entry.getKey());
                parameterInfo.setCollectedValue(entry.getValue());
            }
        }

        if (psMap != null) {
            for (Map.Entry<Integer, ParameterStatus> entry : psMap.entrySet()) {
                ParameterInfo parameterInfo;
                if (pMap.containsKey(entry.getKey())) {
                    parameterInfo = pMap.get(entry.getKey());
                } else {
                    parameterInfo = new ParameterInfo();
                    pMap.put(entry.getKey(), parameterInfo);
                }
                parameterInfo.setParameterId(entry.getKey());
                parameterInfo.setParameterStatus(entry.getValue());

            }
        }

        if(pnList!=null){
            for(Parameter parameter:pnList){
                if(pMap.containsKey(parameter.getId())){
                    ParameterInfo parameterInfo=pMap.get(parameter.getId());
                    parameterInfo.setParameter(parameter);
                }
            }
        }
        parameterInfos=new ArrayList<ParameterInfo>(pMap.values());
    }

}
