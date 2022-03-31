package com.scd.contest.week255;

import java.util.Arrays;

/**
 * @author James
 */
public class Code5850 {

    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        return getGCD(min, max);
    }

    public int getGCD(int num1, int num2) {
        int gcd = 1;
        for (int i = 2; i <= num1; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
