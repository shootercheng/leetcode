package com.scd.exercise.y2021.m3;

/**
 * @author James
 */
public class Code1732 {

    public int largestAltitude(int[] gain) {
        int leng = gain.length;
        int start = 0;
        int max = start;
        for (int i = 0; i < leng; i++) {
            int temp = start + gain[i];
            if (temp > max) {
                max = temp;
            }
            start = temp;
        }
        return max;
    }
}
