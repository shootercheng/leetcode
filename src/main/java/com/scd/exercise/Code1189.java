package com.scd.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code1189 {

    public int maxNumberOfBalloons(String text) {
        char[] textArr = text.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        countMap.put('b', 0);
        countMap.put('a', 0);
        countMap.put('l', 0);
        countMap.put('o', 0);
        countMap.put('n', 0);
        for (char c : textArr) {
            Integer count = countMap.get(c);
            if (count != null) {
                countMap.put(c, ++count);
            }
        }
        Set<Map.Entry<Character, Integer>> entrySet = countMap.entrySet();
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : entrySet) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (key == 'b' || key == 'a' || key == 'n') {
                if (value < min) {
                    min = value;
                }
            } else if (key == 'l' || key == 'o') {
                value = value / 2;
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String text = "leetcode";
        Code1189 code1189 = new Code1189();
        code1189.maxNumberOfBalloons(text);
    }
}
