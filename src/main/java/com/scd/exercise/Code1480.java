package com.scd.exercise;

/**
 * @author James
 */
public class Code1480 {

    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + nums[i];
            result[i] = sum;
        }
        return result;
    }
}
