package com.scd.exercise.m12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code973 {

    public int[][] kClosest(int[][] points, int K) {
        List<int[]> sortedPointList = Arrays.stream(points).sorted(Comparator.comparing(this::sort))
                .collect(Collectors.toList());
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = sortedPointList.get(i);
        }
        return result;
    }


    private int sort(int[] t) {
        int x = Math.abs(t[0]);
        int y = Math.abs(t[1]);
        return x*x + y*y;
    }
}
