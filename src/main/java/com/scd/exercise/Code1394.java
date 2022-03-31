package com.scd.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code1394 {

    public int findLucky(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr) {
            Integer count = countMap.computeIfAbsent(i, k -> 0);
            countMap.put(i, ++count);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (key == value.intValue() && key > max) {
                max = key;
            }
        }
        return max;
    }
}
