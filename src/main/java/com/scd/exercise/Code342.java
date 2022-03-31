package com.scd.exercise;

/**
 * @author James
 */
public class Code342 {
    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 4) {
            return false;
        }
        int m = n;
        while (true) {
            int mod = m % 4;
            if (mod != 0) {
                return false;
            }
            m = m / 4;
            if (m < 4) {
                break;
            }
        }
        if (m != 1) {
            return false;
        }
        return true;
    }
}
