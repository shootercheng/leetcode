package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Mcode1624 {

    public List<List<Integer>> pairSums(int[] nums, int target) {
        int lenn = nums.length;
        boolean[] used = new boolean[lenn];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < lenn; i++) {
            for (int j = i+1; j < lenn; j++) {
                if (nums[i] + nums[j] == target && !used[i] && !used[j]) {
                    used[i] = true;
                    used[j] = true;
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
