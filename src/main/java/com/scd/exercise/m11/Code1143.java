package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();
        int lentext1 = text1.length();
        int lentext2 = text2.length();
        if (lentext1 > lentext2) {
            return findLongCommonStr(text1Arr, text2Arr);
        } else {
            return findLongCommonStr(text2Arr, text1Arr);
        }
    }

    private int findLongCommonStr(char[] text1Arr, char[] text2Arr) {
        int lentext1 = text1Arr.length;
        int startIndex = 0;
        int i = 0;
        int max = Integer.MIN_VALUE;
        for (char c : text2Arr) {
            startIndex = findCommonChar(text1Arr, lentext1, startIndex, c);
            if (startIndex != -1) {
                i++;
                if (i > max) {
                    max = i;
                }
            } else {
                i = 0;
                startIndex = 0;
            }
        }
        if (max == Integer.MIN_VALUE) {
            max = 0;
        }
        return max;
    }

    private int findCommonChar(char[] text1Arr, int lentext1, int startIndex, char c) {
        for (int i = startIndex; i < lentext1; i++) {
            if (text1Arr[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Code1143 code1143 = new Code1143();
//        System.out.println(code1143.longestCommonSubsequence("abcde","ace"));
//        System.out.println(code1143.longestCommonSubsequence("abc","abc"));
//        "psnw"
//        "vozsh"
        System.out.println(code1143.longestCommonSubsequence("psnw","vozsh"));
    }
}
