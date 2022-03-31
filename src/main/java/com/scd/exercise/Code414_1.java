package com.scd.exercise;

import java.util.Arrays;

/**
 * @author James
 */
public class Code414_1 {

    public int thirdMax(int[] nums) {
        int m1 = Integer.MIN_VALUE;
        int m2 = Integer.MIN_VALUE;
        int m3 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == m1 || num == m2 || num == m3) {
                continue;
            }
            if (num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = num;
            } else if (num > m2) {
                m3 = m2;
                m2 = num;
            } else if (num > m3) {
                m3 = num;
            }
        }
        if (m3 != Integer.MAX_VALUE) {
            return m3;
        } else {
            return m1;
        }
    }

    public static void main(String[] args) {
        Code414_1 code414_1 = new Code414_1();
        int[] nums = {-2147483648,1,1};
        code414_1.thirdMax(nums);
    }
}
