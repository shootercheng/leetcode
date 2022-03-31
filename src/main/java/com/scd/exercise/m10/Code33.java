package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code33 {

    public int search(int[] nums, int target) {
        int tIndex = -1;
        int nlen = nums.length;
        for (int i = 0; i < nlen; i++) {
            if (nums[i] == target) {
                tIndex = i;
                break;
            }
        }
        return tIndex;
    }
}
