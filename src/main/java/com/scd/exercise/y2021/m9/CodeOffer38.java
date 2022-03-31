package com.scd.exercise.y2021.m9;

/**
 * @author James
 */
public class CodeOffer38 {

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
