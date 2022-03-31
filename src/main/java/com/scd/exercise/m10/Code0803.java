package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code0803 {

    public int findMagicIndex(int[] nums) {
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,5};
        Code0803 code0803 = new Code0803();
        System.out.println(code0803.findMagicIndex(nums));
    }
}
