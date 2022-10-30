package com.scd.exercise.y2022.m9.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code2404 {


    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = -1;
        for (int num : nums) {
            if (num % 2 == 0) {
                Integer count = countMap.computeIfAbsent(num, k -> 0);
                countMap.put(num, ++count);
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        if (countMap.size() == 0) {
            return maxCount;
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                list.add(entry.getKey());
            }
        }
        list = list.stream().sorted().collect(Collectors.toList());
        return list.get(0);
    }
}
