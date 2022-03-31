package com.scd.exercise;

/**
 * @author James
 */
public class Code189 {

    public void rotate(int[] nums, int k) {
        int max = nums.length - 1;
        for (int j = 0; j < k; j++) {
            int temp = nums[max];
            for (int i = max; i >= 1; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
    }
}
