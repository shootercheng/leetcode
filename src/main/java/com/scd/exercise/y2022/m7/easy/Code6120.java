package com.scd.exercise.y2022.m7.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code6120 {

    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.computeIfAbsent(num,  k -> 0);
            countMap.put(num, ++count);
        }
        int pair = 0;
        int notPair = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int count = entry.getValue();
            if (count % 2 != 0) {
                notPair++;
            }
            pair = pair + count / 2;
        }
        int[] result = new int[2];
        result[0] = pair;
        result[1] = notPair;
        return result;
    }
}
