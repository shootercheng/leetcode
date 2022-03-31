package com.scd.exercise;

/**
 * @author James
 */
public class Code190 {

    public int reverseBits(int n) {
        String binaryStr = Integer.toBinaryString(n);
        int zeroLen = 32 - binaryStr.length();
        String zeroStr = createZeroStr(zeroLen);
        StringBuilder reverseBuilder = new StringBuilder(zeroStr);
        reverseBuilder.append(binaryStr);
        return Integer.parseUnsignedInt(reverseBuilder.reverse().toString(), 2);
    }

    private String createZeroStr(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result = result + "0";
        }
        return result;
    }
}
