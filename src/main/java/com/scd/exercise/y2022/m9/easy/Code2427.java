package com.scd.exercise.y2022.m9.easy;

public class Code2427 {

    public int commonFactors(int a, int b) {
        int loopNum = Math.min(a, b);
        int count = 0;
        for (int i = 1; i <= loopNum; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }
}
