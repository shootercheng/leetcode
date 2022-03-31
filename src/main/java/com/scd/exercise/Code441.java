package com.scd.exercise;

import java.math.BigInteger;

/**
 * @author James
 */
public class Code441 {

    public int arrangeCoins(int n) {
        int row = 1;
        int temp = n;
        while (true) {
            temp = temp - row;
            if (temp < 0) {
                row--;
                break;
            }
            row++;
        }
        return row;
    }

    /**
     * (1 + t) * t / 2 = n
     * (1 + t) * t = 2 * n
     *
     *
     *
     * @param n
     * @return
     */
    public int arrangeCoins2(int n) {
        int temp = (int) (Math.sqrt(2) * Math.sqrt(n));
        BigInteger bigT = new BigInteger(String.valueOf(temp));
        BigInteger sum = new BigInteger("1").add(bigT).multiply(bigT);
        BigInteger bigN = new BigInteger(String.valueOf(n)).multiply(new BigInteger("2"));
        if (sum.compareTo(bigN) <= 0) {
            return temp;
        }
        return temp - 1;
    }

    public static void main(String[] args) {
        Code441 code441 = new Code441();
        System.out.println(code441.arrangeCoins2(5));
        System.out.println(code441.arrangeCoins2(8));
        System.out.println(code441.arrangeCoins2(5050));
        System.out.println(code441.arrangeCoins2(2147483647));
    }
}
