package com.ccy.netty;

import com.ccy.utils.ByteUtil;
import com.ccy.utils.CRCUtil;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
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
     * 采集器发送的命令
     */
    public byte cmd;

    /**
     * 采集值
     */
    public List<SensorValue> sensorValues;

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
            } else  if(CRCUtil.getCRC16(data, 0, totalLength - 3)
                    == ByteUtil.getInt(data, totalLength - 3, 2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((char) data[1]);
                stringBuilder.append((char) data[2]);
                stringBuilder.append((char) data[3]);
                // stringBuilder.append((char)data[4]);
                areaNo = stringBuilder.toString();

                collectorNo = data[8] - 0x30;
                collectorNo += (data[7] - 0x30) * 10;
                collectorNo += (data[6] - 0x30) * 100;
                collectorNo += (data[5] - 0x30) * 1000;

                cmd = data[11];

                int dataLength = ByteUtil.getInt(data, 12, 2);
                int len, index = 14;
                sensorValues = new ArrayList<SensorValue>(32);
                while (index <= dataLength + 11) {
                    len = data[index]; // 中间所有数据占的字节长度
                    byte dataType = data[index + 3];
                    if (dataType == 0x00) { // float
                        SensorValue sensorValue = new SensorValue();
                        sensorValue.paramNo =
                                ByteUtil.getInt(data, index + 1, 2);
                        sensorValue.value = ByteUtil.getFloat(data, index + 5);
                        sensorValues.add(sensorValue);
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

    @Override
    public String toString() {
        return "CCYCollectedData{" +
                "areaNo='" + areaNo + '\'' +
                ", collectorNo=" + collectorNo +
                ", sensorValues=" + sensorValues + '}';
    }
}
