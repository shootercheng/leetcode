package com.scd.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code347 {

    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.computeIfAbsent(num, n -> 0);
            countMap.put(num, ++count);
        }
        List<Integer> countOrders = countMap.values().stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        if (countOrders.size() >= k) {
            int min = countOrders.get(k - 1);
            Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
            for (Map.Entry<Integer, Integer> entry : entrySet) {
                if (entry.getValue() >= min) {
                    result.add(entry.getKey());
                }
            }
            int[] intArr = new int[result.size()];
            int lenr = result.size();
            for (int i = 0; i < lenr; i++) {
                intArr[i] = result.get(i);
            }
            return intArr;
        }
        return new int[]{};
    }
}
