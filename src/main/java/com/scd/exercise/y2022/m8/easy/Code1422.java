package com.scd.exercise.y2022.m8.easy;

/**
 * @author James
 */
public class Code1422 {

    public int maxScore(String s) {
        int countOne = 0;
        char[] sArr = s.toCharArray();
        for (char schar : sArr) {
            if (schar == '1') {
                countOne++;
            }
        }
        int max = 0;
        int lens = sArr.length;
        for (int i = 0; i < lens; i++) {
            int countLeftOne = 0;
            int countLeftZero = 0;
            for (int j = 0; j <= i; j++) {
                if (sArr[j] == '0') {
                    countLeftZero++;
                } else {
                    countLeftOne++;
                }
            }
            int curSum = countLeftZero + countOne - countLeftOne;
            if (curSum > max) {
                max = curSum;
            }
        }
        return max;
    }
}
