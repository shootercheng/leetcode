package com.scd.exercise.y2022.m9.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Code2441 {

    public int findMaxK(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (Integer num : nums) {
            numSet.add(num);
        }
        Arrays.sort(nums);
        int lenn = nums.length;
        for (int i = lenn - 1; i >= 0; i--) {
            int neNum = 0 - nums[i];
            if (numSet.contains(neNum)) {
                return nums[i];
            }
        }
        return -1;
    }
}
