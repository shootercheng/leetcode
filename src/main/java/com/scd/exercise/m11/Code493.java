package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code493 {
    public int reversePairs(int[] nums) {
        int lenn = nums.length;
        int count = 0;
        for (int i = 0; i < lenn; i++) {
            for (int j = i+1; j < lenn; j++) {
                if (nums[i] - nums[j] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-5,-5};
        Code493 code493 = new Code493();
        System.out.println(code493.reversePairs(nums));
    }
}
