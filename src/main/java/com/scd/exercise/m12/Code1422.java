package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code1422 {

    public int maxScore(String s) {
        char[] sArr = s.toCharArray();
        int oneNum = 0;
        for (char c : sArr) {
            if (c == '1') {
                oneNum++;
            }
        }
        int lens = sArr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <=  lens - 1; i++) {
            int curZero = 0;
            int curOne = 0;
            for (int j = 0; j < i; j++) {
                if (sArr[j] == '0') {
                    curZero++;
                } else {
                    curOne++;
                }
            }
            int left = curZero;
            int right = oneNum - curOne;
            int sum = left + right;
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Code1422 code1422 = new Code1422();
        System.out.println(code1422.maxScore("011101"));
    }
}
