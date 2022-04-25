package com.scd.exercise.y2022.m4.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1909 {

    public boolean canBeIncreasing(int[] nums) {
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            int[] newNums = new int[lenn - 1];
            int index = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                newNums[index++] = nums[j];
            }
            int count = 0;
            for (int j = 0; j < newNums.length - 1; j++) {
                if (newNums[j] < newNums[j+1]) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == newNums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code1909 code1909 = new Code1909();
        System.out.println(code1909.canBeIncreasing(new int[]{100,21,100}));
        System.out.println(code1909.canBeIncreasing(new int[]{1,1}));
        System.out.println(code1909.canBeIncreasing(new int[]{1,1,1}));
        System.out.println(code1909.canBeIncreasing(new int[]{105,924,32,968}));
    }
}
