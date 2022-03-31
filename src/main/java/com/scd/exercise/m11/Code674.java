package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code674 {
    public int findLengthOfLCIS(int[] nums) {
        int lenn = nums.length;
        if (lenn == 0) {
            return 0;
        }
        int max = 1;
        int temp = 1;
        for (int i = 0; i < lenn - 1; i++) {
            if (nums[i] < nums[i+1]) {
                temp++;
            } else {
                if (temp > max) {
                    max = temp;
                }
                temp = 1;
            }
        }
        if (temp > max) {
            max = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        Code674 code674 = new Code674();
        int[] nums = {1,3,5,7};
        System.out.println(code674.findLengthOfLCIS(nums));
    }
}
