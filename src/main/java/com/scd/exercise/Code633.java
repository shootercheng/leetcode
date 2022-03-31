package com.scd.exercise;

/**
 * @author James
 */
public class Code633 {

    public boolean judgeSquareSum(int c) {
        double res = Math.sqrt(c);
        String strRes = String.valueOf(res);
        int maxNum = (int) res + 1;
        for (int i = 0; i < maxNum; i++) {
            for (int j = 0; j < maxNum; j++) {
                int sum = i + j;
                if (c + 2 * i * j == sum * sum) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code633 code633 = new Code633();
//        for (int i = 0; i <= 100; i++) {
//            code633.judgeSquareSum(i);
//        }
        code633.judgeSquareSum(4);
    }
}
