package com.scd.exercise.m12;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code3_1 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                String subStr = s.substring(i, j);
                if (!isSame(subStr) && subStr.length() > maxLen) {
                    maxLen = subStr.length();
                }
            }
        }
        return maxLen;
    }

    private boolean isSame(String subStr) {
        char[] charArr = subStr.toCharArray();
        Set<Character> set = new HashSet<>(charArr.length);
        for (char c : charArr) {
            set.add(c);
        }
        if (set.size() != subStr.length()) {
            return true;
        }
        return false;
    }
}
