package com.scd.exercise;

/**
 * @author James
 */
public class Code238 {

    public int[] productExceptSelf(int[] nums) {
        int lenn = nums.length;
        int[] result = new int[lenn];
        for (int i = 0; i < lenn; i++) {
            result[i] = calMulti(nums, i, lenn);
        }
        return result;
    }

    private int calMulti(int[] nums, int i, int len) {
        int result = 1;
        for (int j = 0; j < len; j++) {
            if (j == i) {
                continue;
            }
            result = result * nums[j];
        }
        return result;
    }
}
