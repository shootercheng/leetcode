package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code202 {
    public boolean isHappy(int n) {
        int result = powerAddEach(n);
        if (result == 1) {
            return true;
        }
        while (true) {
            result = powerAddEach(result);
            if (result == 1) {
                return true;
            }
            if (result < 10) {
                return false;
            }
        }
    }

    private int powerAddEach(int n) {
        int temp = n;
        int sum = 0;
        while (temp >= 10) {
            int mod = temp % 10;
            sum = sum + mod * mod;
            temp = temp / 10;
        }
        int mod = temp % 10;
        sum = sum + mod * mod;
        return sum;
    }

    public static void main(String[] args) {
        Code202 code202 = new Code202();
        System.out.println(code202.isHappy(10));
    }
}
