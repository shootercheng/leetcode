package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class Code521 {

    public int findLUSlength(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int maxLen = -1;
        String maxStr = "";
        String minStr = "";
        int strMax = 0;
        if (lena > lenb) {
            maxStr = a;
            minStr = b;
            strMax = lena;
        } else {
            maxStr = b;
            minStr = a;
            strMax = lenb;
        }
        for (int i = 0; i < strMax; i++) {
            for (int j = i+1; j <= strMax; j++) {
                String subStr = maxStr.substring(i, j);
                if (!minStr.contains(subStr)) {
                    int curLen = maxStr.length();
                    if (curLen > maxLen) {
                        maxLen = curLen;
                    }
                }
//                System.out.println(subStr);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abcdefghijklmn";
        Code521 code521 = new Code521();
        System.out.println(code521.findLUSlength(str, str));
    }
}
