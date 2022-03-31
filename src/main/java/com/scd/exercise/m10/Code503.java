package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code503 {
    public int[] nextGreaterElements(int[] nums) {
        int lenn = nums.length;
        int[] result = new int[lenn];
        for (int i = 0; i < lenn; i++) {
            boolean isFind = false;
            for (int j = 0; j < lenn; j++) {
                if (nums[j] > nums[i]) {
                    result[i] = nums[j];
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                result[i] = -1;
            }
        }
        return result;
    }
}
