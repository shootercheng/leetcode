package com.scd.exercise;

import java.math.BigInteger;

/**
 * @author James
 */
public class Code66 {

    public int[] plusOne(int[] digits) {
        BigInteger inputNum = convertArrToBig(digits);
        inputNum = inputNum.add(new BigInteger("1"));
        char[] charArray = inputNum.toString().toCharArray();
        int blen = charArray.length;
        int[] result = new int[blen];
        for (int i = 0; i < blen; i++) {
            result[i] = charArray[i] - 48;
        }
        return result;
    }

    private BigInteger convertArrToBig(int[] digits) {
        int len = digits.length;
        StringBuilder stringBuilder = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            stringBuilder.append(digits[i]);
        }
        return new BigInteger(stringBuilder.toString());
    }

    public static void main(String[] args) {
        Code66 code66 = new Code66();
        int[] digits = new int[]{1,2,3,4};
        int[] result = code66.plusOne(digits);
        System.out.println(result);
    }
}
