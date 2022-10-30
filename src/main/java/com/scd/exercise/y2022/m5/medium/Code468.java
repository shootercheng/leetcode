package com.scd.exercise.y2022.m5.medium;

/**
 * @author James
 */
public class Code468 {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            if (queryIP.startsWith(".") || queryIP.endsWith(".")) {
                return "Neither";
            }
            String[] ipArr = queryIP.split("\\.");
            if (ipArr.length != 4) {
                return "Neither";
            }
            for (String segment : ipArr) {
                if (segment.length() > 1 && segment.startsWith("0")) {
                    return "Neither";
                }
                try {
                    int num = Integer.parseInt(segment);
                    if (num < 0 || num > 255) {
                        return "Neither";
                    }
                } catch (Exception e) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (queryIP.contains(":")) {
            if (queryIP.startsWith(":") || queryIP.endsWith(":")) {
                return "Neither";
            }
            String[] ipArr = queryIP.split(":");
            if (ipArr.length != 8) {
                return "Neither";
            }
            for (String segment : ipArr) {
                int lens = segment.length();
                if (lens < 1 || lens > 4) {
                    return "Neither";
                }
                for (int i = 0; i < lens; i++) {
                    char curChar = segment.charAt(i);
                    if (Character.isLowerCase(curChar)) {
                        if (!(curChar >= 'a' && curChar <= 'f')) {
                            return "Neither";
                        }
                    } else if (Character.isUpperCase(curChar)) {
                        if (!(curChar >= 'A' && curChar <= 'F')) {
                            return "Neither";
                        }
                    } else {
                        if (!Character.isDigit(curChar)) {
                            return "Neither";
                        }
                    }
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

    public static void main(String[] args) {
        String str = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        Code468 code468 = new Code468();
        code468.validIPAddress(str);

    }
}
