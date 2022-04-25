package com.scd.exercise.y2022.m4.easy;

/**
 * @author James
 */
public class Code1848 {

    public int getMinDistance(int[] nums, int target, int start) {
        int lenn = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lenn; i++) {
            if (nums[i] == target) {
                int abs = Math.abs(i - start);
                if (abs < min) {
                    min = abs;
                }
            }
        }
        return min;
    }
}
