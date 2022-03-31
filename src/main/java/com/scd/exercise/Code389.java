package com.scd.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code389 {

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> wordCountMap = new HashMap<>();
        char[] tcharArr = t.toCharArray();
        for (char c : tcharArr) {
            Integer count = wordCountMap.computeIfAbsent(c, k -> 0);
            wordCountMap.put(c, ++count);
        }
        char[] scharArr = s.toCharArray();
        for (char c : scharArr) {
            Integer count = wordCountMap.get(c);
            if (count == 1) {
                wordCountMap.remove(c);
            } else {
                wordCountMap.put(c, --count);
            }
        }
        int size = wordCountMap.size();
        if (size != 1) {
            return '0';
        }
        return wordCountMap.keySet().iterator().next();
    }

    public static void main(String[] args) {
        Code389 code389 = new Code389();
        char sr = code389.findTheDifference("aabcd", "aabcde");
        System.out.println(sr);
    }
}
