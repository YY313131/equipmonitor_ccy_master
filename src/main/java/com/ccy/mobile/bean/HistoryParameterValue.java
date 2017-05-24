package com.ccy.mobile.bean;

import com.ccy.dto.CollectedValue;

import java.util.List;

/**
 * Created by dsz on 17/5/24.
 */
public class HistoryParameterValue {


    private int paramterId;
    private List<CollectedValue> collectedValues;

    public HistoryParameterValue(int paramterId, List<CollectedValue> collectedValues) {
        this.paramterId = paramterId;
        this.collectedValues = collectedValues;
    }

    public int getParamterId() {
        return paramterId;
    }

    public void setParamterId(int paramterId) {
        this.paramterId = paramterId;
    }

    public List<CollectedValue> getCollectedValues() {
        return collectedValues;
    }

    public void setCollectedValues(List<CollectedValue> collectedValues) {
        this.collectedValues = collectedValues;
    }
}
