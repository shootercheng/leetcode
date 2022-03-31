package com.scd.exercise.m10;

import java.util.Arrays;

/**
 * @author James
 */
public class MCode1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int lena = A.length;
        int lenb = B.length;
        for (int i = m, j = 0; i < lena && j < lenb; i++,j++) {
            A[i] = B[j];
        }
        Arrays.sort(A);
    }
}
