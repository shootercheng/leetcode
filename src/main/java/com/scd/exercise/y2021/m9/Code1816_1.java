package com.scd.exercise.y2021.m9;

/**
 * @author James
 */
public class Code1816_1 {

    public String truncateSentence(String s, int k) {
        String[] sArr = s.split("\\s+");
        int lens = sArr.length;
        if (lens <= k) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < k; i++) {
            result.append(sArr[i]).append(" ");
        }
        return result.toString().trim();
    }
}
