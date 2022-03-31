package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class Code1668 {

    public int maxRepeating(String sequence, String word) {
        int max = 0;
        String curWord = "";
        while (sequence.contains(curWord)) {
            curWord = curWord + word;
            max++;
        }
        return max - 1;
    }
}
