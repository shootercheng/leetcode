package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1304 {

    public int[] sumZero(int n) {
        int[] result = new int[n];
        if (n % 2 == 0) {
            int loop = n / 2;
            genAsc(result, loop);
            genDesc(n, result, loop);
        } else {
            int mid = n / 2;
            result[mid] = 0;
            genAsc(result, mid);
            int start = mid + 1;
            genDesc(n, result, start);
        }
        return result;
    }

    private void genDesc(int n, int[] result, int loop) {
        for (int i = loop; i < n; i++) {
            result[i] = loop - i - 1;
        }
    }

    private void genAsc(int[] result, int mid) {
        for (int i = 0; i < mid; i++) {
            result[i] = i + 1;
        }
    }
}
