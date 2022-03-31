package com.scd.exercise;

import java.math.BigInteger;

/**
 * @author James
 */
public class Code172 {
    public int trailingZeroes(int n) {
        BigInteger result = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            BigInteger ele = new BigInteger(String.valueOf(i));
            result = result.multiply(ele);
        }
        char[] chars = result.toString().toCharArray();
        int count = 0;
        int loopStart = chars.length - 1;
        for (int i = loopStart; i >= 0; i--) {
            if (chars[i] == '0') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Code172 code172 = new Code172();
        System.out.println(code172.trailingZeroes(6));
    }
}
