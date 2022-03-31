package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class Code217 {

    public boolean containsDuplicate(int[] nums) {
        int lenn = nums.length;
        if (lenn == 1) {
            return false;
        }
        Arrays.sort(nums);
        int start = nums[0];
        for (int i = 1; i < lenn; i++) {
            int next = nums[i];
            if (start == next) {
                return true;
            }
            start = next;
        }
        return false;
    }

    public static void main(String[] args) {
        Code217 code217 = new Code217();
        System.out.println(code217.containsDuplicate(new int[]{1,3,4,5,2,1}));
    }
}
