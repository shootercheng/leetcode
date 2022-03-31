package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code29 {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        return dividend / divisor;
    }

    public static void main(String[] args) {
        Code29 code29 = new Code29();
        code29.divide(Integer.MIN_VALUE, -1);
    }
}
