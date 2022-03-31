package com.scd.exercise.m10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int lens = s.length();
        char[] sArr = s.toCharArray();
        Map<Character, Integer> CHAR_MAP = new HashMap<>();
        int max = 0;
        for (int i = 0; i < lens; i++) {
            Integer index = CHAR_MAP.get(sArr[i]);
            if (index != null) {
                int temp = i - index - 1;
                if (temp > max) {
                    max = temp;
                }
            } else {
                CHAR_MAP.put(sArr[i], i);
            }
        }
        return max;
    }
}
