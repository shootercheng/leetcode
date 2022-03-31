package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code1317 {

    public int[] getNoZeroIntegers(int n) {
        int[] result = new int[2];
        for (int i = 1; i <= n - 1; i++) {
            String istr = String.valueOf(i);
            String otherStr = String.valueOf(n - i);
            if (!istr.contains("0") && !otherStr.contains("0")) {
                result[0] = i;
                result[1] = n - i;
                return result;
            }
        }
        return result;
    }
}
