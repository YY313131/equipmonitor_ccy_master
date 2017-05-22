package com.ccy.netty;

/**
 * Created by dsz on 17/5/19.
 */
public class SensorValue implements Comparable<SensorValue>{
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
        return "SensorValue{" +
                "value=" + value +
                ", paramNo=" + paramNo +
                '}';
    }
    public int compareTo(SensorValue o) {
        return paramNo - o.paramNo;
    }
}
