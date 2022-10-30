package com.scd.exercise.y2022.m7.easy;

import java.util.Arrays;

/**
 * @author James
 */
public class Code6132 {

    public int minimumOperations(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int lenn = nums.length;
        while (true) {
            int notZeroIndex = -1;
            for (int i = 0; i < lenn; i++) {
                if (nums[i] != 0) {
                    notZeroIndex = i;
                    break;
                }
            }
            if (notZeroIndex == - 1) {
                break;
            }
            int temp = nums[notZeroIndex];
            for (int i = notZeroIndex; i < lenn; i++) {
                nums[i] = nums[i] - temp;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,0,3,5};
        Code6132 code6132 = new Code6132();
        code6132.minimumOperations(nums);
    }
}
