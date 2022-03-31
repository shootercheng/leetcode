package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code896 {

    public boolean isMonotonic(int[] A) {
        int lena = A.length;
        boolean asc = false;
        boolean desc = false;
        for (int i = 0; i < lena - 1; i++) {
            if (A[i] < A[i+1]) {
                asc = true;
            }
            if (A[i] > A[i+1]) {
                desc = true;
            }
        }
        if (asc && desc) {
            return false;
        }
        return true;
    }
}
