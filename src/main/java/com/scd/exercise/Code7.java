package com.scd.exercise;

import java.math.BigInteger;

/**
 * Integer.MIN_VALUE == -2147483648
 * Integer.MAX_VALUE == 2147483647
 * @author James
 */
public class Code7 {

    public static void main(String[] args) {
        int x = 1534236469;
        int result;
        if (x < 0) {
            String str = String.valueOf(x).substring(1);
            result = convertStrToNegative(str);
        } else if (x > 0) {
            String str = String.valueOf(x);
            result = convertStrNoNegative(str);
        } else {
            result = 0;
        }
        System.out.println(result);
    }

    private static int convertStrToNegative(String inputStr) {
        char[] charArr = inputStr.toCharArray();
        int result = 0;
        int multmin = Integer.MIN_VALUE / 10;
        int loopStart = charArr.length - 1;
        for (int i=loopStart; i >= 0; i--) {
            int digit = (int) charArr[i] - 48;
            if (result < multmin) {
                return 0;
            }
            result = result * 10 - digit;
            if (result > 0) {
                return 0;
            }
        }
        return result;
    }


    private static int convertStrNoNegative(String inputStr) {
        char[] charArr = inputStr.toCharArray();
        int result = 0;
        int multmin = Integer.MAX_VALUE / 10;
        int loopStart = charArr.length - 1;
        for (int i= loopStart; i >= 0; i--) {
            int digit = (int) charArr[i] - 48;
            if (result > multmin) {
                return 0;
            }
            result = result * 10 + digit;
            if (result < 0) {
                return 0;
            }
        }
        return result;
    }
}
