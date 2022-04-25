package com.scd.exercise.y2022.m4.easy;

import java.util.Arrays;

/**
 * LCP 28. 采购方案
 * @author James
 */
public class CodeLcp28 {

    public int purchasePlans(int[] nums, int target) {
        int lenn = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < lenn; i++) {
            for (int j = i + 1; j < lenn; j++) {
                if (nums[i] + nums[j] <= target) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count % 1000000007;
    }
}
