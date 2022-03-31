package com.scd.exercise.y2021.m3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code1752 {

    public boolean check(int[] nums) {
        int lenn = nums.length;
        int[] temp = new int[lenn];
        System.arraycopy(nums,0, temp, 0, lenn);
        Arrays.sort(nums);
        List<Integer> xList = new ArrayList<>();
        for (int i = 0; i < lenn; i++) {
            for (int x = 0; x < lenn; x++) {

            }
        }
//        int[] temp =
//        System.arraycopy();
        return false;
    }

    public static void main(String[] args) {
        int len = 2;
        for (int i = 0; i < 100; i++) {
            int mod = i % 2;
            System.out.println(mod);
        }
    }
}

// i = 0 x = 1   1 % 2 = 1
// i = 1 x = 1   2 % 2 = 0;