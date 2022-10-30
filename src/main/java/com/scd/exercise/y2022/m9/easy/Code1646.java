package com.scd.exercise.y2022.m9.easy;

public class Code1646 {

    public int getMaximumGenerated(int n) {
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                int numIndex = i / 2;
                nums[i] = nums[numIndex] + nums[numIndex + 1];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
