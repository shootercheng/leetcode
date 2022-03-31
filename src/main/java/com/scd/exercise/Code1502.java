package com.scd.exercise;

import java.util.Arrays;

/**
 * @author James
 */
public class Code1502 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        int len = arr.length;
        if (len == 2) {
            return true;
        }
        Arrays.sort(arr);
        int num = arr[1] - arr[0];
        for (int i = 2; i < len; i++) {
            if (arr[i] - arr[i - 1] != num) {
                return false;
            }
        }
        return true;
    }
}
