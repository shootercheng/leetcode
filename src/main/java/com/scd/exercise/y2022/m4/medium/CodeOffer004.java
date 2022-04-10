package com.scd.exercise.y2022.m4.medium;

import java.util.Arrays;

/**
 * 剑指 Offer II 004. 只出现一次的数字
 * @author James
 */
public class CodeOffer004 {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
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

    public static void main(String[] args) {
        CodeOffer004 codeOffer004 = new CodeOffer004();
        codeOffer004.singleNumber(new int[]{30000,500,500,100,30000,100,30000,100,30001});
    }
}
