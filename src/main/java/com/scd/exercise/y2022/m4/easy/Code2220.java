package com.scd.exercise.y2022.m4.easy;

/**
 * @author James
 */
public class Code2220 {

    public int minBitFlips(int start, int goal) {
        String startStr = Integer.toBinaryString(start);
        String goalStr = Integer.toBinaryString(goal);
        int lens = startStr.length();
        int leng = goalStr.length();
        int maxLen;
        if (lens > leng) {
            goalStr = appendZero(lens - leng) + goalStr;
            maxLen = lens;
        } else {
            startStr = appendZero(leng - lens) + startStr;
            maxLen = leng;
        }
        int count = 0;
        for (int i = 0; i < maxLen; i++) {
            if (startStr.charAt(i) != goalStr.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private String appendZero(int len) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append("0");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Code2220 code2220 = new Code2220();
        code2220.minBitFlips(10, 7);
    }
}
