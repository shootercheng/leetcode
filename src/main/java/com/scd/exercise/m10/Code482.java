package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code482 {

    public String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "");
        int lens  = S.length();
        if (lens <= K) {
            return S.toUpperCase();
        }
        int mod = lens % K;
        char[] charArr = S.toCharArray();
        StringBuilder result = new StringBuilder();
        if (mod != 0) {
            for (int i = 0; i < mod; i++) {
                result.append(Character.toUpperCase(charArr[i]));
            }
            result.append("-");
        }
        for (int i = mod; i < lens; i = i + K) {
            for (int j = i; j < i + K; j++) {
                result.append(Character.toUpperCase(charArr[j]));
            }
            if (i < lens - K) {
                result.append("-");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        "5F3Z-2e-9-w"
//        4
        String S = "5F3Z-2e-9-w";
        int k = 4;
        Code482 code482 = new Code482();
        String result = code482.licenseKeyFormatting(S, k);
        System.out.println(result);
    }
}
