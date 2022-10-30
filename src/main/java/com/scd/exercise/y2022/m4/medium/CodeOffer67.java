package com.scd.exercise.y2022.m4.medium;

import javax.xml.stream.events.Characters;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 * @author James
 */
public class CodeOffer67 {

    public int strToInt(String str) {
        str = str.trim();
        boolean isNegative = false;
        if (str.startsWith("-")) {
            isNegative = true;
            str = str.substring(1);
        } else if (str.startsWith("+")) {
            str = str.substring(1);
        }
        char[] strArr = str.toCharArray();
        int lens = strArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lens; i++) {
            char curChar = strArr[i];
            if (Character.isDigit(curChar)) {
                stringBuilder.append(curChar);
            } else {
                break;
            }
        }
        if (stringBuilder.length() == 0) {
            return 0;
        }
        String temp = stringBuilder.toString();
        if (isNegative) {
            temp = "-" + temp;
            try {
                return Integer.parseInt(temp);
            } catch (Exception e) {
                return Integer.MIN_VALUE;
            }
        } else {
            try {
                return Integer.parseInt(temp);
            } catch (Exception e) {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        CodeOffer67 codeOffer67 = new CodeOffer67();
        codeOffer67.strToInt("  -0003242424-234323424");
    }
}
