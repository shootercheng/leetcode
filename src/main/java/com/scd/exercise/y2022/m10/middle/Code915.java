package com.scd.exercise.y2022.m10.middle;


import java.util.Arrays;

/**
 * 分割数组
 */
public class Code915 {

    public int partitionDisjoint(int[] nums) {
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            Arrays.sort(nums, 0, i+1);
            int leftMax = nums[i];
            int rightMin = Integer.MAX_VALUE;
            for (int j = i + 1; j < lenn; j++) {
                if (nums[j] < rightMin) {
                    rightMin = nums[j];
                }
            }
            if (leftMax <= rightMin) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Code915 code915 = new Code915();
        code915.partitionDisjoint(new int[]{1,1,1,1,6,12});
    }
}
