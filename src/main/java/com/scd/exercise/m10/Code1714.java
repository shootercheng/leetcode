package com.scd.exercise.m10;

import java.util.Arrays;

/**
 * @author James
 */
public class Code1714 {

    public int[] smallestK(int[] arr, int k) {
        int[] result = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
