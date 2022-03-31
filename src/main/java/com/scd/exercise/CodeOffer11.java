package com.scd.exercise;

/**
 * @author James
 */
public class CodeOffer11 {

    public int minArray(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int i : numbers) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }
}
