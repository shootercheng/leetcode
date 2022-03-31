package com.scd.exercise.y2022.m3;

import java.util.Arrays;

/**
 * 6020. 将数组划分成相等数对
 * @author James
 */
public class Code6020 {

    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int temp = nums[0];
        int lenn = nums.length;
        for (int i = 1; i < lenn; i++) {
            if (nums[i] == temp) {
                count++;
            } else {
                if (count % 2 != 0) {
                    return false;
                }
                count = 1;
                temp = nums[i];
            }
        }
        return count % 2 == 0;
    }
}
