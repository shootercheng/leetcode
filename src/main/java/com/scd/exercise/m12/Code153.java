package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code153 {

    public int findMin(int[] nums) {
        int lenn = nums.length;
        if (lenn == 0) {
            return 0;
        }
        if (lenn == 1) {
            return nums[0];
        }
        for (int i = 1; i < lenn; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
