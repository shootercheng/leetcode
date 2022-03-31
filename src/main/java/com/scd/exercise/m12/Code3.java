package com.scd.exercise.m12;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code3 {

    public int lengthOfLongestSubstring(String s) {
        int lens = s.length();
        int startIndex = 0;
        int endIndex = 0;
        Set<Character> charSet = new HashSet<>();
        int count = 0;
        int max = Integer.MIN_VALUE;
        while (endIndex < lens) {
            char curChar = s.charAt(endIndex);
            if (!charSet.contains(curChar)) {
                charSet.add(curChar);
                count++;
                endIndex = endIndex + 1;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
                charSet.clear();
                startIndex = startIndex + 1;
                endIndex = startIndex;
            }
        }
        if (count > max) {
            max = count;
        }
        if (max == Integer.MIN_VALUE) {
            return 0;
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        Code3 code3 = new Code3();
        System.out.println(code3.lengthOfLongestSubstring(str));
    }
}
