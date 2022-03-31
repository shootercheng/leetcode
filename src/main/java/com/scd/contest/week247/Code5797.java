package com.scd.contest.week247;

import java.util.Arrays;

/**
 * @author James
 */
public class Code5797 {

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len - 1] * nums[len -2] - nums[0] * nums[1];
    }
}
