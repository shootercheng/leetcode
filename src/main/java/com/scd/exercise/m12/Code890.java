package com.scd.exercise.m12;

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
            if (isMapped(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    public boolean isMapped(String word, String pattern) {
        int lenw = word.length();
        int lenp = pattern.length();
        if (lenw != lenp) {
            return false;
        }
        Map<Character, Character> charMap = new HashMap<>();
        Set<Character> mappedChar = new HashSet<>();
        for (int i = 0; i < lenw; i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);
            Character mapped = charMap.get(p);
            if (mapped != null) {
                if (w != mapped) {
                    return false;
                }
            } else {
                // a -> c  b -> c
                if (mappedChar.contains(w)) {
                    return false;
                }
                mappedChar.add(w);
                charMap.put(p, w);
            }
        }
        return true;
    }
}
