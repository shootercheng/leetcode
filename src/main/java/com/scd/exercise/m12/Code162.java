package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code162 {

    public int findPeakElement(int[] nums) {
        int lenn = nums.length;
        if (lenn < 2) {
            return 0;
        }
        for (int i = 1; i < lenn - 1; i++) {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                return i;
            }
        }
        // 末端
        if (nums[lenn - 1] > nums[lenn - 2]) {
            return lenn - 1;
        }
        // 起点
        if (lenn == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            }
        }
        return -1;
    }
}
