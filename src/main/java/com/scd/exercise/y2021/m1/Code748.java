package com.scd.exercise.y2021.m1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> licenseMap = countWordMap(licensePlate);
        Set<Character> keySet = licenseMap.keySet();
        int minLen = Integer.MAX_VALUE;
        String result = "";
        for (String word : words) {
            Map<Character, Integer> curMap = countWordMap(word);
            if (isSame(licenseMap, curMap, keySet)) {
                int lenw = word.length();
                if (lenw < minLen) {
                    minLen = lenw;
                    result = word;
                }
            }
        }
        return result;
    }

    private boolean isSame(Map<Character, Integer> licenseMap, Map<Character, Integer> curMap, Set<Character> keySet) {
        for (Character key : keySet) {
            Integer count = curMap.get(key);
            if (count == null) {
                return false;
            }
            Integer licenseCount = licenseMap.get(key);
            if (count < licenseCount) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> countWordMap(String inputWord) {
        char[] inputArr = inputWord.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : inputArr) {
            if (Character.isLetter(c)) {
                char lowerChar = Character.toLowerCase(c);
                Integer count = countMap.computeIfAbsent(lowerChar, k -> 0);
                countMap.put(lowerChar, ++count);
            }
        }
        return countMap;
    }

    public static void main(String[] args) {
        String licensePlate = "GrC8950";
        String[] words = new String[]{"measure","other","every","base","according",
                "level","meeting","none","marriage","rest"};
        Code748 code748 = new Code748();
        code748.shortestCompletingWord(licensePlate, words);
    }
}
