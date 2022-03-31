package com.scd.exercise.y2022.m3;

/**
 * @author James
 */
public class Code2185 {

    public int prefixCount(String[] words, String pref) {
        int result = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                result++;
            }
        }
        return result;
    }
}
