package com.scd.exercise.y2021.m9;

/**
 * @author James
 */
public class Code495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = duration;
        int lent = timeSeries.length;
        int time = timeSeries[0];
        for (int i = 1; i < lent; i++) {
            if (time + duration <= timeSeries[i]) {
                sum = sum + duration;
            } else {
                sum = sum + timeSeries[i] - timeSeries[i - 1];
            }
            time = timeSeries[i];
        }
        return sum;
    }
}
