package com.scd.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class CodeOffer53I {

    public int search(int[] nums, int target) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int count = countMap.computeIfAbsent(num, k -> 0);
            countMap.put(num, ++count);
        }
        Integer result = countMap.get(target);
        if (result == null) {
            return 0;
        }
        return result;
    }
}
