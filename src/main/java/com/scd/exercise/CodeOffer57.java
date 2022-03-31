package com.scd.exercise;

/**
 * @author James
 */
public class CodeOffer57 {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                    return result;
                }
            }
        }
        return result;
    }
}
