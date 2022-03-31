package com.scd.exercise.y2022.m3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code2154 {

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        while (numSet.contains(original)) {
            original = original * 2;
        }
        return original;
    }
}
