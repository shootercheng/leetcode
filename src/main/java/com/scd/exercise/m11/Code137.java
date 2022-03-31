package com.scd.exercise.m11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code137 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            Integer count = countMap.computeIfAbsent(i, k -> 0);
            countMap.put(i, ++count);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
