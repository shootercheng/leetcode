package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code1266 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;
        int lenp = points.length;
        int[] start = points[0];
        for (int i = 1; i < lenp; i++) {
            int[] next = points[i];
            int step = Math.max(Math.abs(start[0] - next[0]), Math.abs(start[1] - next[1]));
            count = count + step;
            start = next;
        }
        return count;
    }
}
