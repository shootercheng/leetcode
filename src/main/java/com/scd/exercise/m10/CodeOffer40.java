package com.scd.exercise.m10;

import java.util.Arrays;

/**
 * @author James
 */
public class CodeOffer40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] leastNums = new int[k];
        for (int i = 0; i < k; i++) {
            leastNums[i] = arr[i];
        }
        return leastNums;
    }
}
