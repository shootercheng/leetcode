package com.scd.exercise.y2021.m7;

import java.util.Arrays;

/**
 * @author James
 */
public class Code1877 {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int lenn = nums.length;
        int i = 0;
        int j = lenn - 1;
        int max = Integer.MIN_VALUE;
        while (i < j) {
            int temp = nums[i] + nums[j];
            if (temp > max) {
                max = temp;
            }
            i++;
            j--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,5,1,2,5,1,5,5,4};
        Code1877 code1877 = new Code1877();
        System.out.println(code1877.minPairSum(nums));
    }
}
