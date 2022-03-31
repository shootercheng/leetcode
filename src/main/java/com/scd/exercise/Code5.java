package com.scd.exercise;

/**
 * 超时了
 * @author James
 */
public class Code5 {

    public static void main(String[] args) {
        String s = "babad";
        int len = s.length();
        int maxLen = -1;
        String maxStr = "";
        if (len > 0) {
            maxStr = s.substring(0, 1);
        }
        for (int i = 0; i < len; i++) {
            for (int j = i+2; j <= len; j++) {
                String subStr = s.substring(i, j);
                System.out.println(subStr);
                if (isPali(subStr) && subStr.length() > maxLen) {
                    maxLen = subStr.length();
                    maxStr = subStr;
                }
            }
        }
        System.out.println(maxStr);
    }

    private static boolean isPali(String subStr) {
        String reverseStr = new StringBuilder(subStr).reverse().toString();
        if (subStr.equals(reverseStr)) {
            return true;
        }
        return false;
    }
}
