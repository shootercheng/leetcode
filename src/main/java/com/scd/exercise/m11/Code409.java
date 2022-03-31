package com.scd.exercise.m11;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code409 {

    public int longestPalindrome(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        char[] strArr = s.toCharArray();
        for (char c : strArr) {
            Integer count = countMap.computeIfAbsent(c, k -> 0);
            countMap.put(c, ++count);
        }
        Set<Map.Entry<Character, Integer>> entrySet = countMap.entrySet();
        int maxLen = 0;
        boolean hasOdd = false;
        for (Map.Entry<Character, Integer> entry : entrySet) {
            Integer value = entry.getValue();
            if (value % 2 == 0) {
                maxLen = maxLen + value;
            } else {
                hasOdd = true;
                value = value - 1;
                if (value > 0) {
                    maxLen = maxLen + value;
                }
            }
        }
        if (hasOdd) {
            maxLen = maxLen + 1;
        }
        return maxLen;
    }
}
