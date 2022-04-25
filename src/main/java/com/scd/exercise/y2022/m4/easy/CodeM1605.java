package com.scd.exercise.y2022.m4.easy;

import java.math.BigInteger;

/**
 * 面试题 16.05. 阶乘尾数
 * @author James
 */
public class CodeM1605 {

    public int trailingZeroes(int n) {
        BigInteger result = BigInteger.ONE;
        while (n != 0) {
            result = result.multiply(new BigInteger(String.valueOf(n)));
            n--;
        }
        char[] charArr = result.toString().toCharArray();
        int lenc = charArr.length;
        int count = 0;
        for (int i = lenc - 1; i >= 0; i--) {
            if (charArr[i] == '0') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
