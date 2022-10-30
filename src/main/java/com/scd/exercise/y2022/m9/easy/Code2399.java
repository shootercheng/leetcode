package com.scd.exercise.y2022.m9.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code2399 {
    private static final Map<Integer, Character> CHAR_MAP = new HashMap<>();

    static {
        char start = 'a';
        for (int i = 0; i < 26; i++) {
            char temp = (char) (start + i);
            CHAR_MAP.put(i, temp);
        }
    }

    public boolean checkDistances(String s, int[] distance) {
        Map<Character, List<Integer>> charMap = new HashMap<>();
        int lens = s.length();
        for (int i = 0; i < lens; i++) {
            char curChar = s.charAt(i);
            List<Integer> indexList = charMap.computeIfAbsent(curChar, k -> new ArrayList<>());
            indexList.add(i);
        }
        int lend = distance.length;
        for (int i = 0; i < lend; i++) {
            char curChar = CHAR_MAP.get(i);
            List<Integer> indexList = charMap.get(curChar);
            if (indexList != null) {
                if (indexList.get(1) - indexList.get(0) - 1 != distance[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
