package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class MCode0501 {

    public int insertBits(int N, int M, int i, int j) {
        String strn = Integer.toBinaryString(N);
        String strm = Integer.toBinaryString(M);
        StringBuilder strnBuilder = new StringBuilder(strn).reverse();
        StringBuilder strmBuilder = new StringBuilder(strm).reverse();
        int lenn = strn.length();
        int lenm = strm.length();
        StringBuilder result = new StringBuilder();
        if (j >= lenn) {
            int dis = j - i + 1;
            if (dis < lenm) {
                for (int k = i; k <= j; j++) {
                    result.append(strmBuilder.charAt(k));
                }
            } else {
                for (int k = i; k < lenm; j++) {
                    result.append(strmBuilder.charAt(k));
                }
            }
            return Integer.parseInt(result.reverse().toString(), 2);
        }
        if (j < lenm) {
            int l = 0;
            for (int k = i; k <= j; k++) {
                strnBuilder.setCharAt(k, strmBuilder.charAt(l));
                l++;
            }
        } else {
            for (int k = i; k < lenm; k++) {
                strnBuilder.setCharAt(k, strmBuilder.charAt(k));
            }
            int zeroNum = j - lenm + 1;
            int startIndex = lenm;
            int k = 0;
            while (k < zeroNum) {
                strnBuilder.setCharAt(startIndex, '0');
                startIndex++;
                k++;
            }
        }
        return Integer.parseInt(strnBuilder.reverse().toString(), 2);
    }

    public static void main(String[] args) {
        MCode0501 mCode0501 = new MCode0501();
        System.out.println(mCode0501.insertBits(1024, 19, 2, 6));
    }
}
