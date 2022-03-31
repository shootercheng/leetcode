package com.scd.exercise.y2021.m8;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code1941 {

    public boolean areOccurrencesEqual(String s) {
        char[] scharArr = s.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : scharArr) {
           int count = charMap.computeIfAbsent(c, k -> 0);
           charMap.put(c, ++count);
        }
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        int temp = 0;
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (temp == 0) {
                temp = entry.getValue();
            } else {
                if (temp != entry.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
