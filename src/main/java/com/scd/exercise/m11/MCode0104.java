package com.scd.exercise.m11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class MCode0104 {

    public boolean canPermutePalindrome(String s) {
        char[] scharArr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : scharArr) {
            Integer count = map.computeIfAbsent(c, k -> 0);
            map.put(c, ++count);
        }
        int sum = 0;
        for (Integer count : map.values()) {
            if (count % 2 != 0) {
                sum++;
            }
        }
        if (sum > 1) {
            return false;
        }
        return true;
    }
}
