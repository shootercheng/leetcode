package com.scd.exercise.m11;

import java.util.Arrays;

/**
 * @author James
 */
public class Code976 {

    public int largestPerimeter(int[] A) {
        int lena = A.length;
        if (lena < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = lena -1; i >= 2; i--) {
            int a = A[i];
            int b = A[i-1];
            int c = A[i-2];
            if (a + b > c && a + c > b && b + c > a) {
                return a+b+c;
            }
        }
        return 0;
    }
}
