package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code307 {

    class NumArray {
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public void update(int i, int val) {
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum = sum + nums[k];
            }
            return sum;
        }
    }
}
