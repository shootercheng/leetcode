package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code338 {

    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i = 0; i <= num; i++) {
            int oneNum = calOneNum(i);
            result[i] = oneNum;
        }
        return result;
    }

    private int calOneNum(int input) {
        int count = 0;
        while (input >= 2) {
            int mod = input % 2;
            if (mod == 1) {
                count++;
            }
            input = input / 2;
        }
        int mod = input % 2;
        if (mod == 1) {
            count++;
        }
        return count;
    }
}
