package com.scd.exercise.y2021.m7;

/**
 * @author James
 */
public class Code5808 {

    public int[] getConcatenation(int[] nums) {
        int lenn = nums.length;
        int[] result = new int[2 * lenn];
        for (int i = 0; i < lenn; i++) {
            result[i] = nums[i];
            result[i+lenn] = nums[i];
        }
        return result;
    }
}
