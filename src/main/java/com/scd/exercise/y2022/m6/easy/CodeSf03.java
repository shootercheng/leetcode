package com.scd.exercise.y2022.m6.easy;

/**
 * @author James
 */
public class CodeSf03 {

    public int findMaxCI(int[] nums) {
        int lenn = nums.length;
        int count = 1;
        int max = 0;
        for (int i = 1; i < lenn; i++) {
            if (nums[i] > nums[i-1]) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 1;
            }
        }
        if (count > max) {
            max = count;
        }
        return max;
    }
}
