package com.ccy.utils;

/**
 * Created by Administrator on 2017/5/22.
 */
public class CRCUtil {

    private static int[] wCRCTalbeAbs = new int[]
            {
                    0x0000, 0xCC01, 0xD801, 0x1400,
                    0xF001, 0x3C00, 0x2800, 0xE401, 0xA001, 0x6C00,
                    0x7800, 0xB401, 0x5000, 0x9C01, 0x8801, 0x4400,
            };

    public static int getCRC16(byte[] data, int start, int length) {
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

}
