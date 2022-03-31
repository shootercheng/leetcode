package com.scd.exercise.y2021.m1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code1221 {

    public int balancedStringSplit(String s) {
        char[] scharArr = s.toCharArray();
        int lens = scharArr.length;
        Map<Character, Integer> charCountMap = new HashMap<>();
        int result = 0;
        for (int i = 0; i < lens; i++) {
            char curChar = scharArr[i];
            Set<Character> keySet = charCountMap.keySet();
            if (keySet.size() == 0) {
                Integer count = charCountMap.computeIfAbsent(curChar, k -> 0);
                charCountMap.put(curChar, ++count);
            } else {
                char key = keySet.iterator().next();
                if (key == curChar) {
                    Integer count = charCountMap.computeIfAbsent(curChar, k -> 0);
                    charCountMap.put(curChar, ++count);
                } else {
                    Integer count = charCountMap.get(key);
                    if (--count == 0) {
                        result++;
                        charCountMap.clear();
                    } else {
                        charCountMap.put(key, count);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Code1221 code1221 = new Code1221();
        System.out.println(code1221.balancedStringSplit("RLLLLRRRLR"));
    }
}
