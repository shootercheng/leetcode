package com.scd.exercise.y2021.m8;

/**
 * @author James
 */
public class CodeOffer003 {

    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = calOneNum(i);
        }
        return result;
    }

    public int calOneNum(int input) {
        int count = 0;
        while (input > 1) {
            int mod = input % 2;
            if (mod == 1) {
                count++;
            }
            input = input / 2;
        }
        if (input == 1) {
            count++;
        }
        return count;
    }
}
