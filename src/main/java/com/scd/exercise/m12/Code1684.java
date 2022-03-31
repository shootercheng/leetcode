package com.scd.exercise.m12;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> charSet = new HashSet<>();
        char[] charArr = allowed.toCharArray();
        for (char c : charArr) {
            charSet.add(c);
        }
        int count = 0;
        for (String word : words) {
            char[] wordArr = word.toCharArray();
            boolean isContain = true;
            for (char wa : wordArr) {
                if (!charSet.contains(wa)) {
                    isContain = false;
                    break;
                }
            }
            if (isContain) {
                count++;
            }
        }
        return count;
    }
}
