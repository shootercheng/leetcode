package com.scd.exercise.m10;

import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code1456 {

    private static List<Character> VOWEL_LIST = Arrays.asList('a','e','i','o','u');

    public int maxVowels(String s, int k) {
        int lens = s.length();
        int[] vowelArr = new int[lens];
        char[] sArr = s.toCharArray();
        for (int i = 0; i < lens; i++) {
            if (VOWEL_LIST.contains(sArr[i])) {
                vowelArr[i] = 1;
            }
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int result = 0;
        for (; right < lens; right++) {
            if (right < k) {
                count = count + vowelArr[right];
                result = count;
                if (result == k) {
                    return k;
                }
            } else {
                count = count + vowelArr[right];
                if (vowelArr[left++] == 1) {
                    count--;
                }
                result = Math.max(result, count);
                if (result == k) {
                    return k;
                }
            }
        }
        return result;
    }
}
