package com.scd.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code5709 {

    public int maxAscendingSum(int[] nums) {
        int lenn = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lenn; i++) {
            for (int j = 0; j < lenn; j++) {
                    int sum = calSum(i, j, nums);
                    if (sum > max) {
                        max = sum;
                    }
            }
        }
        return max;
    }

    private int calSum(int i, int j, int[] nums) {
        if (i == j) {
            return nums[i];
        }
        int len = nums.length;
        if (i + 1 == len) {
            return nums[i];
        }
        int temp = nums[i];
        int sum = temp;
        for (int k = i+1; k <= j; k++) {
            if (nums[k] <= temp) {
                return -1;
            }
            temp = nums[k];
            sum = sum + nums[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {6,10,6};
        Code5709 code5709 = new Code5709();
        code5709.maxAscendingSum(nums);
    }
}
