package com.scd.contest.week245;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code5784 {

    public boolean makeEqual(String[] words) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (String word : words) {
            char[] wordArr = word.toCharArray();
            for (char c : wordArr) {
                Integer count = charCountMap.computeIfAbsent(c, k -> 0);
                charCountMap.put(c, ++count);
            }
        }
        int lenw = words.length;
        Set<Map.Entry<Character, Integer>> entrySet = charCountMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() % lenw != 0) {
                return false;
            }
        }
        return true;
    }
}
