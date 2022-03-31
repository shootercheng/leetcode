package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1137 {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int[] record = new int[n+1];
        record[0] = 0;
        record[1] = 1;
        record[2] = 1;
        for (int i = 3; i <= n; i++) {
            record[i] = record[i-3] + record[i-2] + record[i-1];
        }
        return record[n];
    }
}
