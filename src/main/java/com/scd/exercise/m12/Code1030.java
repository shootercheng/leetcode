package com.scd.exercise.m12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code1030 {

    private int[] origin = new int[2];

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R*C][2];
        int c = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result[c] = new int[]{i, j};
                c++;
            }
        }
        origin[0] = r0;
        origin[1] = c0;
        Arrays.sort(result, Comparator.comparingInt(this::sort));
        return result;
    }

    private int sort(int[] data) {
        return Math.abs(origin[0] - data[0]) + Math.abs(origin[1] - data[1]);
    }

    public static void main(String[] args) {
        Code1030 code1030 = new Code1030();
        code1030.allCellsDistOrder(1,2,0,0);
    }
}
