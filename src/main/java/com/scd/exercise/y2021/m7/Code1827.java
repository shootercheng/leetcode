package com.scd.exercise.y2021.m7;

import java.util.Arrays;

/**
 * @author James
 */
public class Code1827 {

    public int minOperations(int[] nums) {
        int lenn = nums.length;
        int sum = 0;
        int start = nums[0];
        for (int i = 1; i < lenn; i++) {
            int next = nums[i];
            if (start >= next) {
                int temp = start + 1;
                sum = sum + temp - next;
                next = temp;
            }
            start = next;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,2,4,1};
        Code1827 code1827 = new Code1827();
        code1827.minOperations(nums);
    }
}
