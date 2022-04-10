package com.scd.exercise.y2022.m4.medium;

/**
 * 剑指 Offer II 070. 排序数组中只出现一次的数字
 * @author James
 */
public class CodeOffer070 {

    public int singleNonDuplicate(int[] nums) {
        int lenn = nums.length;
        if (lenn == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < lenn - 1; i++) {
            if (nums[i] == temp) {
                count++;
            } else {
                count = 1;
                temp = nums[i];
            }
            if (count == 1 && nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[lenn - 1];
    }
}
