package com.scd.exercise.m12;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author James
 */
public class Code1637 {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(this::sort));
        int max = Integer.MIN_VALUE;
        int lenp = points.length;
        int[] start = points[0];
        for (int i = 0; i < lenp; i++) {
            int[] next = points[i];
            int dis = next[0] - start[0];
            if (dis > max) {
                max = dis;
            }
            start = next;
        }
        return max;
    }

    private int sort(int[] t) {
        return t[0];
    }
}
