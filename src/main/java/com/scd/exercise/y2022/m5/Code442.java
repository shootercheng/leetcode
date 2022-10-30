package com.scd.exercise.y2022.m5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code442 {

    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.computeIfAbsent(num, k -> 0);
            countMap.put(num, ++count);
        }
        List<Integer> result = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() == 2) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
