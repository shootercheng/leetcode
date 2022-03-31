package com.scd.exercise.y2022.m3;

import com.scd.exercise.y2021.m1.Code208;

import java.util.HashMap;
import java.util.Map;

/**
 * 2068. 检查两个字符串是否几乎相等
 * @author James
 */
public class Code2068 {

    public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> map1 = countMap(word1);
        Map<Character, Integer> map2 = countMap(word2);
        for (int i = 'a'; i < 'a' + 26; i++) {
            char curChar = (char) i;
            Integer count1 = map1.getOrDefault(curChar, 0);
            Integer count2 = map2.getOrDefault(curChar, 0);
            if (Math.abs(count1 - count2) > 3) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> countMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        char[] wordArr = word.toCharArray();
        int lenw = word.length();
        for (int i = 0; i < lenw; i++) {
            Integer count = map.computeIfAbsent(wordArr[i], k -> 0);
            map.put(wordArr[i], ++count);
        }
        return map;
    }

    public static void main(String[] args) {
        Code2068 code2608 = new Code2068();

        code2608.checkAlmostEquivalent("zzzyyy",
                "iiiiii");
    }
}
