package com.scd.exercise.m12;

import java.util.Arrays;

/**
 * @author James
 */
public class Code540 {

    public int singleNonDuplicate(int[] nums) {
        int lenn = nums.length;
        if (lenn == 1) {
            return nums[0];
        }
        int i = 0;
        while (i < lenn) {
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
            i = i + 2;
            if (i == lenn - 1) {
                return nums[i];
            }
        }
        return -1;
    }
}
