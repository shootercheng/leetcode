package com.scd.exercise.m12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code1704 {
    private static Set<Character> VOWEL_SET = new HashSet<>(Arrays.asList(
            'a','e','i','o','u',
            'A','E','I','O','U'
    ));

    public boolean halvesAreAlike(String s) {
        int lens = s.length();
        int center = lens / 2;
        String left = s.substring(0, center);
        String right = s.substring(center);
        if (countVowel(left) == countVowel(right)) {
            return true;
        }
        return false;
    }

    private int countVowel(String inputStr) {
        char[] inputArr = inputStr.toCharArray();
        int count = 0;
        for (char c : inputArr) {
            if (VOWEL_SET.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
