package com.scd.exercise.y2022.m9.easy;

/**
 * 6180. 最小偶倍数
 * @author James
 */
public class Code6180 {

    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        }
        return n * 2;
    }
}
