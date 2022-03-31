package com.scd.exercise.m10;

import java.util.Arrays;

/**
 * @author James
 */
public class Code1619 {

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int lena = arr.length;
        int del = lena * 5 / 100;
        double sum = 0;
        for (int i = del; i < lena - del; i++) {
            sum = sum + arr[i];
        }
        return (double) sum / (lena - 2 * del);
    }
}
