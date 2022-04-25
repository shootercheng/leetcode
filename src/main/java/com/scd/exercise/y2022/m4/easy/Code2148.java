package com.scd.exercise.y2022.m4.easy;

import java.util.Arrays;

/**
 * @author James
 */
public class Code2148 {

    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int lenn = nums.length;
        if (lenn < 3) {
            return 0;
        }
        int min = nums[0];
        int max = nums[lenn - 1];
        int count = lenn - 2;
        for (int i = 1; i <= lenn - 2; i++) {
            if (nums[i] == min) {
                count--;
            } else if (nums[i] == max) {
                count--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {11,7,2,15};
        Code2148 code2148 = new Code2148();
        code2148.countElements(nums);
    }
}
