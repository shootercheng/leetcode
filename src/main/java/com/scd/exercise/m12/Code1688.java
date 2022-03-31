package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code1688 {

    public int numberOfMatches(int n) {
        int temp = n;
        int sum = 0;
        while (temp != 1) {
            sum = sum + temp / 2;
            if (temp % 2 == 0) {
                temp = temp / 2;
            } else {
                temp = (temp - 1) / 2 + 1;
            }
        }
        return sum;
    }
}
