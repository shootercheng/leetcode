package com.scd.contest.week256;

import java.util.Arrays;

/**
 * @author James
 */
public class Code5854 {

    public int minimumDifference(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int start = 0;
        int lenn = nums.length;
        int min = Integer.MAX_VALUE;
        while (start < lenn) {
            int end = start + k - 1;
            if (end >= lenn) {
                break;
            }
            int cal = nums[end] - nums[start];
            if (cal < min) {
                min = cal;
            }
            start = start + 1;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {87063,61094,44530,21297,95857,93551,9918};
        int[] nums1 = {9,4,1,7};
        Code5854 code5854 = new Code5854();
        System.out.println(code5854.minimumDifference(nums1, 2));
    }
}
