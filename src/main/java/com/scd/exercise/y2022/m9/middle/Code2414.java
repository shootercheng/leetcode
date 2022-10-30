package com.scd.exercise.y2022.m9.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长的字母序连续子字符串的长度
 * @author James
 */
public class Code2414 {

    private static final Map<Character, Integer> CHAR_MAP = new HashMap<>();

    static {
        char start = 'a';
        for (int i = 0; i < 26; i++) {
            char temp = (char) (start + i);
            CHAR_MAP.put(temp, i);
        }
    }

    public int longestContinuousSubstring(String s) {
        int result = 1;
        int lens = s.length();
        char preChar = s.charAt(0);
        int count = 1;
        char curChar = s.charAt(0);
        for (int i = 1; i < lens; i++) {
            curChar = s.charAt(i);
            if (CHAR_MAP.get(curChar) - CHAR_MAP.get(preChar) == 1) {
                count++;
                if (count > result) {
                    result = count;
                }
            } else {
                count = 1;
            }
            preChar = curChar;
        }
        if (CHAR_MAP.get(curChar) - CHAR_MAP.get(preChar) == 1) {
            count++;
        }
        if (count > result) {
            result = count;
        }
        return result;
    }
}
