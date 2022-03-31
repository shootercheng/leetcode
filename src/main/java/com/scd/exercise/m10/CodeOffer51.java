package com.scd.exercise.m10;

/**
 * @author James
 */
public class CodeOffer51 {

    public int reversePairs(int[] nums) {
        int lenn = nums.length;
        int result = 0;
        for (int i = 0; i < lenn; i++) {
            for (int j = i+1; j < lenn; j++) {
                if (nums[i] > nums[j]) {
                    result++;
                }
            }
        }
        return result;
    }
}
