package com.scd.contest.week248;

/**
 * @author James
 */
public class Code5800 {

    public int[] buildArray(int[] nums) {
        int lenn = nums.length;
        int[] result = new int[lenn];
        for (int i = 0; i < lenn; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
