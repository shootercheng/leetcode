package com.scd.exercise;

/**
 * @author James
 */
public class Code5_1 {

    public String maxLenSubStr(String inputStr) {
        int len = inputStr.length();
        int maxLen = 0;
        String maxStr = "";
        for (int i = 0; i < len; i++) {
            // 奇数回文串 aba
            String palindStr = findPalindrome(inputStr, i, i);
            if (palindStr.length() > maxLen) {
                maxLen = palindStr.length();
                maxStr = palindStr;
            }
            // 偶数回文串 abba
            String palindStrOdd = findPalindrome(inputStr, i, i+1);
            if (palindStrOdd.length() > maxLen) {
                maxLen = palindStrOdd.length();
                maxStr = palindStrOdd;
            }
        }
        return maxStr;
    }

    public String findPalindrome(String inputStr, int left, int right) {
        // aba、 abba
        int len = inputStr.length();
        while ( (left >= 0) && (right < len) && (inputStr.charAt(left) == inputStr.charAt(right)) ) {
            left--;
            right++;
        }
        return inputStr.substring(left + 1, right);
    }

    public static void main(String[] args) {
        String inputStr = "bb";
        Code5_1 code5_1 = new Code5_1();
        System.out.println(code5_1.maxLenSubStr(inputStr));
    }
}
