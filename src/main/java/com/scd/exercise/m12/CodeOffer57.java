package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class CodeOffer57 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            List<Integer> indexList = numIndexMap.computeIfAbsent(nums[i], k -> new ArrayList<>());
            indexList.add(i);
        }
        int[] result = new int[2];
        for (int num : nums) {
            int other = target - num;
            if (num == other) {
                if (numIndexMap.get(num).size() >= 2) {
                    result[0] = num;
                    result[1] = num;
                }
            } else {
                List<Integer> oIndexList = numIndexMap.get(other);
                if (oIndexList != null) {
                    result[0] = num;
                    result[1] = other;
                }
            }
        }
        return result;
    }
}
