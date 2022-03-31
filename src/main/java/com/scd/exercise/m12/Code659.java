package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code659 {

    public boolean isPossible(int[] nums) {
        int lenn = nums.length;
        if (lenn <= 3) {
            return false;
        }
        Arrays.sort(nums);
        int temp = nums[0];
        int startIndex = 0;
        for (int i = 1; i < lenn; i++) {
            if (nums[i] - temp != 1) {
                if (i - startIndex < 2) {
                    return false;
                } else {
                    startIndex = i;
                    if (startIndex < lenn) {
                        temp = nums[i];
                    }
                }
            } else {
                temp = nums[i];
            }
        }
        if (lenn - 1 - startIndex < 2) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,4,5};
        Code659 code659 = new Code659();
//        System.out.println(code659.isPossible(nums));
        System.out.println(code659.isPossible(new int[]{1,2,3,3,4,5}));
    }
}
