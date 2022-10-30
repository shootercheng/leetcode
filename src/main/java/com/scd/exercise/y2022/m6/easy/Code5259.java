package com.scd.exercise.y2022.m6.easy;

/**
 * @author James
 */
public class Code5259 {

    private static final double DPUBLE_HUN = 100d;

    public double calculateTax(int[][] brackets, int income) {
        int lenb = brackets.length;
        double sum = 0;
        for (int i = 0; i < lenb; i++) {
            if (income > brackets[i][0]) {
                if (i == 0) {
                    sum = sum + brackets[i][0] * brackets[i][1] / DPUBLE_HUN;
                } else {
                    sum = sum + (brackets[i][0] - brackets[i - 1][0]) * brackets[i][1] / DPUBLE_HUN;
                }
            } else {
                if (i == 0) {
                    return income * brackets[i][1] / DPUBLE_HUN;
                } else {
                    sum = sum + (income - brackets[i - 1][0]) * brackets[i][1] / DPUBLE_HUN;
                }
            }
        }
        return sum;
    }
}
