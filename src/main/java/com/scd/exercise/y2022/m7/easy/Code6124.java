package com.scd.exercise.y2022.m7.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code6124 {

    public char repeatedCharacter(String s) {
        int lens = s.length();
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < lens; i++) {
            char curChar = s.charAt(i);
            Integer count = charMap.computeIfAbsent(curChar, k -> 0);
            if (count == 1) {
                return curChar;
            }
            charMap.put(curChar, ++count);
        }
        return s.charAt(0);
    }
}
