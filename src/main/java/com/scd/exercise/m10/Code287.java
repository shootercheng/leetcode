package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code287 {

    public int findDuplicate(int[] nums) {
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            for (int j = i+1; j < lenn; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
