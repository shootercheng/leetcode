package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code1071 {
    public String gcdOfStrings(String str1, String str2) {
        String maxLenStr = "";
        String minLenStr = "";
        if (str1.length() > str2.length()) {
            maxLenStr = str1;
            minLenStr = str2;
        } else {
            maxLenStr = str2;
            minLenStr = str1;
        }
        int index = maxLenStr.indexOf(minLenStr);
        if (index == -1) {
            return "";
        }
        return "";
    }
}
