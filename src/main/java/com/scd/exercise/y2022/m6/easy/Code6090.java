package com.scd.exercise.y2022.m6.easy;

/**
 * @author James
 */
public class Code6090 {

    public int minMaxGame(int[] nums) {
        int lenn = nums.length;
        while (lenn != 1) {
            int loop = lenn / 2;
            for (int i = 0; i < loop; i++) {
                if (i % 2 == 0) {
                    nums[i] = Math.min(nums[2*i], nums[2*i + 1]);
                } else {
                    nums[i] = Math.max(nums[2*i], nums[2*i + 1]);
                }
            }
            lenn = loop;
        }
        return nums[0];
    }
}
