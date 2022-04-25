package com.scd.exercise.y2022.m4.easy;

/**
 * @author James
 */
public class Code0801 {

    public int waysToStep(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n + 1];
        record[1] = 1;
        record[2] = 2;
        record[3] = 4;
        if (n < 4) {
            return record[n];
        }
        for (int i = 4; i <= n; i++) {
            record[i] = record[i - 1] % 1000000007;
            record[i] = (record[i] + record[i - 2]) % 1000000007;
            record[i] = (record[i] + record[i - 3]) % 1000000007;
        }
        return record[n];
    }

    public static void main(String[] args) {
        Code0801 code0801 = new Code0801();
        code0801.waysToStep(1000000);
    }
}
