package com.scd.exercise.y2022.m3;

/**
 * 2057. 值相等的最小索引
 * @author James
 */
public class Code2057 {

    public int smallestEqual(int[] nums) {
        int result = -1;
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            if (nums[i] % 10 == nums[i]) {
                result = i;
                break;
            }
        }
        return result;
    }
}
