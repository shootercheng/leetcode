package com.scd.exercise.y2021.m1;

import java.util.Stack;

/**
 * @author James
 */
public class Code762 {

    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            int oneNum = countOneNum(i);
            if (isPrime(oneNum)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int oneNum) {
        if (oneNum <= 1) {
            return false;
        }
        for (int i = 2; i * i <= oneNum; i++) {
            if (oneNum % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int countOneNum(int input) {
        int count = 0;
        int temp = input;
        while (temp >= 1) {
            int mod = temp % 2;
            if (mod == 1) {
                count++;
            }
            temp = temp / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Code762 code762 = new Code762();
        code762.countOneNum(15);
        code762.countPrimeSetBits(10, 15);
    }
}
