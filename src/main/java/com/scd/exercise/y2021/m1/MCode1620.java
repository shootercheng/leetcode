package com.scd.exercise.y2021.m1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class MCode1620 {
    private static Map<Character, List<Character>> map = new HashMap<>();

    static {
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y', 'z'));
    }

    public List<String> getValidT9Words(String num, String[] words) {
        char[] numCharArr = num.toCharArray();
        List<String> resultList = new ArrayList<>();
        for (String word : words) {
            if (isT9Word(numCharArr, word)) {
                resultList.add(word);
            }
        }
        return resultList;
    }

    private boolean isT9Word(char[] numCharArr, String word) {
        int lenw = word.length();
        if (lenw != numCharArr.length) {
            return false;
        }
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < lenw; i++) {
            List<Character> charList = map.get(numCharArr[i]);
            if (!charList.contains(wordArr[i])) {
                return false;
            }
        }
        return true;
    }
}
