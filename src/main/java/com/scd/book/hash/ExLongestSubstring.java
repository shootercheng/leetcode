package com.scd.book.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class ExLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int lens = s.length();
        int left = 0;
        int right = 0;
        Set<Character> charSet = new HashSet<>();
        int max = 0;
        while (right < lens) {
            char curChar = s.charAt(right);
            if (!charSet.contains(curChar)) {
                charSet.add(curChar);
                right++;
            } else {
                charSet.clear();
                int count = right - left;
                if (count > max) {
                    max = count;
                }
                left = left + 1;
                right = left;
            }
        }
        int count = right - left;
        if (count > max) {
            max = count;
        }
        return max;
    }

    public static void main(String[] args) {
        ExLongestSubstring exLongestSubstring = new ExLongestSubstring();
        String s = "aab";
        System.out.println(exLongestSubstring.lengthOfLongestSubstring(s));
    }
}
