package com.ccy.websocket;

import io.netty.buffer.ByteBuf;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dsz on 17/5/19.
 */
public class CCYCollectedData{

    /**
     * 地区编号
     */
    public int areaNo;

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

    public CCYCollectedData(ByteBuf byteBuf){

        int totalLength = 0;
        if(byteBuf == null)
            errorMsg = "message is null!";
        else if((totalLength = byteBuf.readableBytes()) < 17) {
            errorMsg = "message's data is null!";
        } else {
            byte[] data = new byte[totalLength];
            byteBuf.readBytes(data);
            if(data[0] != 0x68 || data[totalLength - 1] != 0x0D){
                errorMsg = "message frame is wrong!";
            } else if (CRC16(data, 0, totalLength-3) == 0){

            }
        }

    }


    private int[] wCRCTalbeAbs = new int[]
    {
        0x0000, 0xCC01, 0xD801, 0x1400, 0xF001, 0x3C00, 0x2800, 0xE401,
            0xA001, 0x6C00, 0x7800, 0xB401, 0x5000, 0x9C01, 0x8801, 0x4400,
    };

    private int CRC16(byte[] data, int start, int length)
    {
        int wCRC;
        int chChar;
        int Chi;
        int Cli;
        wCRC = 0xFFFF;

        for (int i = start; i < length; i++)
        {
            chChar = data[i] & 0xFF;

            wCRC = wCRCTalbeAbs[(chChar ^ wCRC) & 15] ^ (wCRC >> 4);
            wCRC = wCRCTalbeAbs[((chChar >> 4) ^ wCRC) & 15] ^ (wCRC >> 4);

        }
        Chi = wCRC % 256;
        Cli = wCRC / 256;
        return (Chi << 8) | Cli;
    }




}
