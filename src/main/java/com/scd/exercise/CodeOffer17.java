package com.scd.exercise;

/**
 * @author James
 */
public class CodeOffer17 {

    public int[] printNumbers(int n) {
        int max = 1;
        for (int i = 0; i < n; i++) {
            max = max * 10;
        }
        int len = max - 1;
        int[] result = new int[len];
        for (int i = 1; i <= len; i++) {
            result[i-1] = i;
        }
        return result;
    }
}
