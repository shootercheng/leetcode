package com.scd.exercise.y2022.m4.easy;

/**
 * @author James
 */
public class Code2180 {

    public int countEven(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            if (isEven(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isEven(int i) {
        int temp = i;
        int sum = 0;
        while (temp > 9) {
            sum = sum + temp % 10;
            temp = temp / 10;
        }
        sum = sum + temp;
        return sum % 2 == 0;
    }
}
