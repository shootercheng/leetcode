package com.scd.exercise.y2021.m1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author James
 */
public class Code1037 {

    public boolean isBoomerang(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(this::sort));
        int[] a = points[0];
        int[] b = points[1];
        int[] c = points[2];
        if (isSame(a, b) || isSame(b, c)) {
            return false;
        }
        double k1 = calSlope(a, b);
        double k2 = calSlope(b, c);
        return k1 - k2 != 0;
    }

    private int sort(int[] point) {
        return point[0];
    }

    private boolean isSame(int[] pointA, int[] pointB) {
        return pointA[0] == pointB[0] && pointA[1] == pointB[1];
    }

    private double calSlope(int[] pointA, int[] pointB) {
        if (pointB[0] - pointA[0] == 0) {
            return Double.MAX_VALUE;
        }
        return (double) (pointB[1] - pointA[1]) / (pointB[0] - pointA[0]);
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {52,86},{12,65},{24,71}
        };
        Code1037 code1037 = new Code1037();
        System.out.println(code1037.isBoomerang(points));
    }
}
