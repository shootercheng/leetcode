package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        int lenc = coordinates.length;
        if (lenc <= 2) {
            return true;
        } else {
            double k = calSlope(coordinates[0], coordinates[1]);
            int[] start = coordinates[1];
            for (int i = 2; i < lenc; i++) {
                int[] next = coordinates[i];
                double temp = calSlope(start, next);
                if (temp - k != 0) {
                    return false;
                }
                start = next;
            }

            return true;
        }
    }

    public double calSlope(int[] pointA, int[] pointB) {
        int xdis = pointA[0] - pointB[0];
        double k = Integer.MAX_VALUE;
        if (xdis != 0) {
            k = (pointA[1] - pointB[1]) / (double) xdis;
        }
        return k;
    }

    public static void main(String[] args) {
//        int[][] input = {{1,2},{2,3},{3,5}};
        int[][] input2 = {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
        Code1232 code1232 = new Code1232();
//        code1232.checkStraightLine(input);
        code1232.checkStraightLine(input2);
    }
}
