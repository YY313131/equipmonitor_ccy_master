package com.ccy.websocket;

/**
 * Created by dsz on 17/5/19.
 */
public class CollectedValue {

    /**
     * 采集值
     */
    public float value;

    /**
     * 参数编号
     */
    public int paramNo;

    @Override
    public String toString() {
        return "CollectedValue{" +
                "value=" + value +
                ", paramNo=" + paramNo +
                '}';
    }
}
