package com.scd.exercise.m10;

/**
 * @author James
 */
public class CodeOffer43 {

    public int countDigitOne(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + countOne(i);
        }
        return sum;
    }

    private int countOne(int i) {
        int count = 0;
        while (i >= 10) {
            int mod = i % 10;
            if (mod == 1) {
                count++;
            }
            i = i / 10;
        }
        if (i == 1) {
            count++;
        }
        return count;
    }
}
