package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code5539 {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.computeIfAbsent(num, k -> 0);
            countMap.put(num, ++count);
        }
        Map<Integer, List<Integer>> valueMap = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            Integer count = entry.getValue();
            List<Integer> keyList = valueMap.computeIfAbsent(count, k -> new ArrayList<>());
            keyList.add(entry.getKey());
        }
        int[] result = new int[nums.length];
        int index = 0;
        List<Integer> sortedList = valueMap.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer count : sortedList) {
            List<Integer> valueList = valueMap.get(count).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            for (Integer value : valueList) {
                for (int i = 0; i < count; i++) {
                    result[index++] = value;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-53,-53,52,52,52,52,-53,-53,52,-53,52,52,52,-53,52,52,-53,52,-53,52,-53,52,52,52,52,52,52,52,52,52,-53,52,-53,52,-53,52,52,52,-53,-53,52,-53,52,52,52,52,-53,-53,-53,-53,-53,52,52,-53,52,-53,52,52,52};
        Code5539 code5539 = new Code5539();
        System.out.println(Arrays.asList(code5539.frequencySort(nums)));
    }
}
