package com.scd.exercise.m11;

import java.util.Arrays;

/**
 * @author James
 */
public class Code164 {

    public int maximumGap(int[] nums) {
        int lenn = nums.length;
        if (lenn < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int firstNum = nums[0];
        for (int i = 1; i < lenn; i++) {
            int nextNum = nums[i];
            int dis = nextNum - firstNum;
            if (dis > max) {
                max = dis;
            }
            firstNum = nextNum;
        }
        return max;
    }
}
