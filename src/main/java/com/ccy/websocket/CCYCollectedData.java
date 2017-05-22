package com.ccy.websocket;

import io.netty.buffer.ByteBuf;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dsz on 17/5/19.
 */
public class CCYCollectedData {

    /**
     * 地区编号
     */
    public String areaNo;

    /**
     * 采集器编号
     */
    public int collectorNo;

    /**
     * 采集值
     */
    public List<CollectedValue> collectedValues;

    /**
     * 错误信息
     */
    public String errorMsg;

    public CCYCollectedData(ByteBuf byteBuf) {
        int totalLength;
        if (byteBuf == null)
            errorMsg = "message is null!";
        else if ((totalLength = byteBuf.readableBytes()) < 17) {
            errorMsg = "message's data is null!";
        } else {
            byte[] data = new byte[totalLength];
            byteBuf.readBytes(data);
            if (data[0] != 0x68 || data[totalLength - 1] != 0x0D) {
                errorMsg = "message frame is wrong!";
            } else  if(CRC16(data, 0, totalLength - 3)
                    == getInt(data, totalLength - 3, 2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((char) data[1]);
                stringBuilder.append((char) data[2]);
                stringBuilder.append((char) data[3]);
                // stringBuilder.append((char)data[4]);
                areaNo = stringBuilder.toString();

                collectorNo = data[8] - 0x30;
                collectorNo |= (data[7] - 0x30) << 8;
                collectorNo |= (data[6] - 0x30) << 16;
                collectorNo |= (data[5] - 0x30) << 24;

                int dataLength = getInt(data, 12, 2);
                int len, index = 14;
                collectedValues = new ArrayList<CollectedValue>(32);
                while (index <= dataLength + 11) {
                    len = data[index]; // 中间所有数据占的字节长度
                    byte dataType = data[index + 3];
                    if (dataType == 0x00) { // float
                        CollectedValue collectedValue = new CollectedValue();
                        collectedValue.paramNo = getInt(data, index + 1, 2);
                        collectedValue.value = getFloat(data, index + 5);
                        collectedValues.add(collectedValue);
                    } else if (dataType == 0x02) {
                        System.out.println(new String(data, index + 2, len - 4));
                    }
                    index += len + 1;
                }
            } else {
                errorMsg = "crc validated failed!";
            }
        }
    }

    private int[] wCRCTalbeAbs = new int[]
            {
                    0x0000, 0xCC01, 0xD801, 0x1400,
                    0xF001, 0x3C00, 0x2800, 0xE401, 0xA001, 0x6C00,
                    0x7800, 0xB401, 0x5000, 0x9C01, 0x8801, 0x4400,
            };

    private int CRC16(byte[] data, int start, int length) {
        int chChar;
        int Chi;
        int Cli;
        int wCRC = 0xFFFF;

        int endIndex = start + length;
        for (int i = start; i < endIndex; i++) {
            chChar = data[i] & 0xFF;
            wCRC = wCRCTalbeAbs[(chChar ^ wCRC) & 0x0F] ^ ((wCRC >> 4) & 0xFFFF);
            wCRC = wCRCTalbeAbs[(((chChar >> 4) & 0xFF) ^ wCRC) & 0x0F] ^ ((wCRC >> 4) & 0xFFFF);
        }
        wCRC &= 0xFFFF;
        Chi = wCRC % 256;
        Cli = wCRC / 256;
        return ((Chi << 8) | Cli) & 0xFFFF;
    }

    private int getInt(byte[] data, int start, int length) {
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

    private float getFloat(byte[] data, int start) {
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

    @Override
    public String toString() {
        return "CCYCollectedData{" +
                "areaNo='" + areaNo + '\'' +
                ", collectorNo=" + collectorNo +
                ", collectedValues=" + collectedValues + '}';
    }
}
