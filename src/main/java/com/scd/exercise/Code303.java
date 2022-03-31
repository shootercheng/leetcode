package com.scd.exercise;

/**
 * @author James
 */
public class Code303 {

    private int[] nums;

    public Code303(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int len = nums.length;
        if (i < 0 || j > len - 1) {
            return 0;
        }
        int sum = 0;
        for (; i <= j; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }
}
