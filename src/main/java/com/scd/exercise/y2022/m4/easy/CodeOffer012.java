package com.scd.exercise.y2022.m4.easy;

/**
 * 	475 ms	39.5 MB
 * 剑指 Offer II 012. 左右两边子数组的和相等
 * @author James
 */
public class CodeOffer012 {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        int lenn = nums.length;
        int leftSum = 0;
        for (int i = 0; i < lenn; i++) {
            int curNum = nums[i];
            int mod = (sum - curNum) % 2;
            if (mod == 0) {
                int rightSum = (sum - curNum) / 2;
                if (rightSum == leftSum) {
                    return i;
                }
            }
            leftSum = leftSum + curNum;
        }
        return -1;
    }
}
