package com.scd.exercise.y2022.m3;

/**
 * @author James
 */
public class Code474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int max = 0;
        for (String numStr : strs) {
            char[] numArr = numStr.toCharArray();
            int one = 0;
            int zero = 0;
            for (char num : numArr) {
                if (num == '1') {
                    one++;
                }
                if (num == '0') {
                    zero++;
                }
            }
            if (zero <= m && one <= n && numArr.length > max) {
                max = numArr.length;
            }
        }
        return max;
    }
}
