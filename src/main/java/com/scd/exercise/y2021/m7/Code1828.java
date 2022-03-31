package com.scd.exercise.y2021.m7;

/**
 * @author James
 */
public class Code1828 {

    public int[] countPoints(int[][] points, int[][] queries) {
        int lenq = queries.length;
        int[] result = new int[lenq];
        for (int i = 0; i < lenq; i++) {
            for (int[] point : points) {
                if (isInCircle(point, queries[i])) {
                    result[i]++;
                }
            }
        }
        return result;
    }

    public boolean isInCircle(int[] point, int[] circle) {
        int x = Math.abs(point[0] - circle[0]);
        int y = Math.abs(point[1] - circle[1]);
        int r = circle[2];
        return r * r >= (x * x + y * y);
    }
}
