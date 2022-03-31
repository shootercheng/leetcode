package com.scd.exercise.y2022.m3;

/**
 * @author James
 */
public class Code2114 {

    public int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for (String sentence : sentences) {
            String[] words = sentence.trim().split("\\s+");
            if (words.length > max) {
                max = words.length;
            }
        }
        return max;
    }
}
