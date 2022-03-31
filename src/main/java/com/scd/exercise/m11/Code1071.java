package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return getGcdStr(str1, str2);
        } else {
            return getGcdStr(str1, str2);
        }
    }

    public String getGcdStr(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 < len2) {
            return getGcdStr(str2, str1);
        } else if (len1 == len2) {
            if (str1.equals(str2)) {
                return str1;
            } else {
                return "";
            }
        } else {
            String temp = str1.substring(0, len2);
            if (!temp.equals(str2)) {
                return "";
            }
            str1 = str1.substring(len2);
            return getGcdStr(str1, str2);
        }
    }

    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        Code1071 code1071 = new Code1071();
//        System.out.println(code1071.gcdOfStrings(str1, str2));
        System.out.println(code1071.gcdOfStrings("ABABAB", "ABAB"));
    }
}
