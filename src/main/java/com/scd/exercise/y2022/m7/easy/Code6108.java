package com.scd.exercise.y2022.m7.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code6108 {
    private static List<Character> characterList = new ArrayList<>();

    static {
        for (int i = 0; i < 26; i++) {
            char curChar = (char) ('a' + i);
            characterList.add(curChar);
        }
    }

    public String decodeMessage(String key, String message) {
        Map<Character, Character> charMap = new HashMap<>();
        int mapIndex = 0;
        int lenk = key.length();
        for (int i = 0; i < lenk; i++) {
            char curChar = key.charAt(i);
            if (Character.isLowerCase(curChar)) {
                Character mapChar = charMap.get(curChar);
                if (mapChar == null) {
                    charMap.put(curChar, characterList.get(mapIndex++));
                }
            }
        }
        int lenm = message.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lenm; i++) {
            char curChar = message.charAt(i);
            if (Character.isLowerCase(curChar)) {
                Character mapChar = charMap.get(curChar);
                if (mapChar != null) {
                    result.append(mapChar);
                }
            } else {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
