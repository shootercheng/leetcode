package com.scd.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int length = nums.length;
        int max = length / 2;
        for (int i = 0; i < length; i++) {
            Integer count = countMap.computeIfAbsent(nums[i], k -> 0);
            count++;
            if (count > max) {
                return nums[i];
            }
            countMap.put(nums[i], count);
        }
        return nums[0];
    }
}
