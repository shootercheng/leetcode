package com.scd.exercise.m10;

import java.util.Random;

/**
 * @author James
 */
public class Code384 {

    class Solution {

        private int[] initNumArr;

        private int[] nums;

        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
            int len = nums.length;
            initNumArr = new int[len];
            for (int i = 0; i < len; i++) {
                initNumArr[i] = nums[i];
            }
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return initNumArr;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                int randomIndex = random.nextInt(len);
                int temp = nums[i];
                nums[i] = nums[randomIndex];
                nums[randomIndex] = temp;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
