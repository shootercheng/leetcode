package com.scd.exercise.y2022.m3;

import java.util.HashMap;
import java.util.Map;

/**
 * 2085. 统计出现过一次的公共字符串
 * @author James
 */
public class Code2085 {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> countMap1 = countMap(words1);
        Map<String, Integer> countMap2 = countMap(words2);
        if (words1.length < words2.length) {
            return getResult(countMap1, countMap2);
        } else {
            return getResult(countMap1, countMap2);
        }
    }

    private int getResult(Map<String, Integer> countMap1, Map<String, Integer> countMap2) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : countMap1.entrySet()) {
            if (entry.getValue() == 1) {
                Integer count2 = countMap2.get(entry.getKey());
                if (count2 != null && count2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private Map<String, Integer> countMap(String[] words1) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words1) {
            Integer count = map.computeIfAbsent(word, k -> 0);
            map.put(word, ++count);
        }
        return map;
    }
}
