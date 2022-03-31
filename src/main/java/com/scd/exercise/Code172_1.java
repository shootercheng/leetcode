package com.scd.exercise;

import java.math.BigInteger;

/**
 * @author James
 */
public class Code172_1 {

    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5; i <= n; i = i+5) {
            int powerf5 = 5;
            while (i % powerf5 == 0) {
                count++;
                powerf5 = powerf5 * 5;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Code172_1 code1721 = new Code172_1();
        System.out.println(code1721.trailingZeroes(6));
    }
}
