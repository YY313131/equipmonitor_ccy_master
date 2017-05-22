package com.ccy.utils;

/**
 * Created by Administrator on 2017/5/22.
 */
public class ByteUtil {

    public static int getInt(byte[] data, int start, int length) {
        if (data == null || length > 4
                || data.length < start + length) {
            throw new IllegalArgumentException("data,start,length");
        }
        int value = 0;
        int factor = 1;
        while (length-- > 0) {
            value += (data[start + length]& 0xFF) * factor;
            factor = factor << 8;
        }
        return value;
    }

    public static float getFloat(byte[] data, int start) {
        int intValue;
        intValue = data[start + 3];
        intValue &= 0xFF;
        intValue |= ((long) data[start + 2] << 8);
        intValue &= 0xFFFF;
        intValue |= ((long) data[start + 1] << 16);
        intValue &= 0xFFFFFF;
        intValue |= ((long) data[start] << 24);
        return Float.intBitsToFloat(intValue);
    }

}
