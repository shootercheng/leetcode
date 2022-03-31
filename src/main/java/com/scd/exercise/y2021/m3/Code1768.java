package com.scd.exercise.y2021.m3;

/**
 * @author James
 */
public class Code1768 {

    public String mergeAlternately(String word1, String word2) {
        int lenw1 = word1.length();
        int lenw2 = word2.length();
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (; i < lenw1; i++) {
            result.append(word1.charAt(i));
            if (i < lenw2) {
                result.append(word2.charAt(i));
            }
        }
        for (; i < lenw2; i++) {
            result.append(word2.charAt(i));
        }
        return result.toString();
    }
}
