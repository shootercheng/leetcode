package com.scd.exercise.y2022.m9.middle;

/**
 * 2443. 反转之后的数字和
 */
public class Code2443 {

    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            String left = String.valueOf(i);
            int reverse = Integer.parseInt(new StringBuilder(left).reverse().toString());
            if (i + reverse == num) {
                return true;
            }
        }
        return false;
    }
}
