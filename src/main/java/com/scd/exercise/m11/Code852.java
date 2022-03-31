package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code852 {

    public int peakIndexInMountainArray(int[] A) {
        int lana = A.length;
        for (int i = 0; i < lana - 1; i++) {
            if (A[i] > A[i+1]) {
                return i;
            }
        }
        return -1;
    }
}
