package com.scd.exercise.y2021.m1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code516 {

    public int longestPalindromeSubseq(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        char[] scharArr = s.toCharArray();
        for (char c : scharArr) {
            Integer count = countMap.computeIfAbsent(c, k -> 0);
            countMap.put(c, ++count);
        }
        Set<Map.Entry<Character, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int countVal = entry.getValue();
            if (countVal > 10) {
                return countVal;
            }
        }
        return 0;
    }
}
