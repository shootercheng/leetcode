package com.scd.exercise.y2022.m3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code2006_1 {

    public int countKDifference(int[] nums, int k) {
        Set<String> indexSet = new HashSet<>();
        int lenn = nums.length;
        int count = 0;
        for (int i = 0; i < lenn; i++) {
            for (int j = 0; j < lenn; j++) {
                if (i == j) {
                    continue;
                }
                String key = i < j ? i + "_" + j : j + "_" + i;
                if (Math.abs(nums[i] - nums[j]) == k && !indexSet.contains(key)) {
                    indexSet.add(key);
                    count++;
                }
            }
        }
        return count;
    }
}
