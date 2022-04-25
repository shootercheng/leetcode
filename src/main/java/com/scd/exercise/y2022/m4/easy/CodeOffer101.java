package com.scd.exercise.y2022.m4.easy;

import java.math.BigInteger;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * @author James
 */
public class CodeOffer101 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        BigInteger[] records = new BigInteger[n+1];
        records[0] = BigInteger.ZERO;
        records[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            records[i] = records[i-1].add(records[i-2]);
        }
        BigInteger big = records[n].mod(new BigInteger("1000000007"));
        return Integer.parseInt(big.toString());
    }

    public static void main(String[] args) {
        CodeOffer101 codeOffer101 = new CodeOffer101();
        codeOffer101.fib(45);
    }
}
