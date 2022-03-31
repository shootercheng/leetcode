package com.scd.exercise;

/**
 * @author James
 */
public class Code231 {

    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 0 || n > Integer.MAX_VALUE) {
            return false;
        }
        try {
            String binaryStr = Integer.toBinaryString(n);
            char[] binArr = binaryStr.toCharArray();
            if (binArr[0] != '1') {
                return false;
            }
            int len = binArr.length;
            for (int i = 1; i < len; i++) {
                if (binArr[i] != '0') {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
