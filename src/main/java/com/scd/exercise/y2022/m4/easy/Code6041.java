package com.scd.exercise.y2022.m4.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code6041 {

    public List<Integer> intersection(int[][] nums) {
        int lenn = nums.length;
        if (lenn == 0) {
            return new ArrayList<>();
        }
        Set<Integer> numSet = new HashSet<>();
        for (int i : nums[0]) {
            numSet.add(i);
        }
        for (int i = 1; i < lenn; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j : nums[i]) {
                if (numSet.contains(j)) {
                    temp.add(j);
                }
            }
            numSet = temp;
            if (numSet.size() == 0) {
                break;
            }
        }
        return numSet.stream().sorted().collect(Collectors.toList());
    }
}
