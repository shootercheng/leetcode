package com.scd.exercise.y2022.m4.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * @author James
 */
public class CodeOffer48 {

    public int lengthOfLongestSubstring(String s) {
        char[] scharArr = s.toCharArray();
        int lens = s.length();
        int startIndex = 0;
        int max = 0;
        Map<Character, Integer> indexMap = new HashMap<>();
        while (startIndex < lens) {
            char curChar = scharArr[startIndex];
            if (!indexMap.containsKey(curChar)) {
                indexMap.put(curChar, startIndex);
            } else {
                Integer index = indexMap.get(curChar);
                startIndex = index + 1;
                int curSize = indexMap.size();
                if (curSize > max) {
                    max = curSize;
                }
                indexMap.clear();
                indexMap.put(scharArr[startIndex], startIndex);
            }
            startIndex++;
        }
        int curSize = indexMap.size();
        if (curSize > max) {
            max = curSize;
        }
        return max;
    }

    public static void main(String[] args) {
        CodeOffer48 codeOffer48 = new CodeOffer48();
        codeOffer48.lengthOfLongestSubstring("dvdf");
    }
}
