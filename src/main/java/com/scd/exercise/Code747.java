package com.scd.exercise;

/**
 * @author James
 */
public class Code747 {

    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < lenn; i++) {
            if (i != maxIndex && max < nums[i] * 2) {
                return -1;
            }
        }
        return maxIndex;
    }
}
