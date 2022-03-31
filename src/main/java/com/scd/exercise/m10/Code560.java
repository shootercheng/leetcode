package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code560 {

    public int subarraySum(int[] nums, int k) {
        int lenn = nums.length;
        int result = 0;
        for (int i = 0; i < lenn; i++) {
            int sum = 0;
            for (int j = i; j < lenn; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
