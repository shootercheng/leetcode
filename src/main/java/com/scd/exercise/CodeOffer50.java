package com.scd.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class CodeOffer50 {

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        char[] scharArr = s.toCharArray();
        Map<Character, Integer> linkCountMap = new LinkedHashMap<>();
        for (char c : scharArr) {
            Integer count = linkCountMap.computeIfAbsent(c, k -> 0);
            linkCountMap.put(c, ++count);
        }
        Set<Map.Entry<Character, Integer>> entrySet = linkCountMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
