package com.scd.exercise.y2022.m6.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (pattern.length() != word.length()) {
                continue;
            }
            char[] pCharArr = pattern.toCharArray();
            char[] wCharArr = word.toCharArray();
            Map<Character, Character> charMap = new HashMap<>();
            Set<Character> mapedSet = new HashSet<>();
            boolean isMatched = true;
            for (int i = 0; i < pCharArr.length; i++) {
                Character mapedChar = charMap.get(pCharArr[i]);
                if (mapedChar == null) {
                    if (mapedSet.contains(wCharArr[i])) {
                        isMatched = false;
                        break;
                    }
                    charMap.put(pCharArr[i], wCharArr[i]);
                    mapedSet.add(wCharArr[i]);
                } else {
                    if (mapedChar != wCharArr[i]) {
                        isMatched = false;
                        break;
                    }
                }
            }
            if (isMatched) {
                result.add(word);
            }
        }
        return result;
    }
}
