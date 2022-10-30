package com.scd.exercise.y2022.m5;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;

/**
 * @author James
 */
public class Code812 {

    public double largestTriangleArea(int[][] points) {
        int lenp = points.length;
        double max = 0;
        for (int i = 0; i < lenp; i++) {
            for (int j = 0; j < lenp; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < lenp; k++) {
                    if (j == k || k == i) {
                        continue;
                    }
                    if (isSameRatio(points[i], points[j], points[k])) {
                        continue;
                    }
                    double x = calLen(points[i], points[j]);
                    double y = calLen(points[j], points[k]);
                    double z = calLen(points[i], points[k]);
                    double p = (x + y + z) / 2;
                    double s = Math.sqrt(p * (p - x) * (p - y) * (p - z));
                    if (s - max > 0.000001) {
                        max = s;
                    }
                }
            }
        }
        return max;
    }

    private boolean isSameRatio(int[] x,  int[] y, int[] z) {
        BigDecimal ratio1 = calRatio(x, y);
        BigDecimal ratio2 = calRatio(y, z);
        return ratio1.compareTo(ratio2) == 0;
    }

    private BigDecimal calRatio(int[] x, int[] y) {
        if (x[0] - y[0] == 0 || x[1] - y[1] == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal bigDecimaly = new BigDecimal(Math.abs(x[0] - y[0]));
        BigDecimal bigDecimalx = new BigDecimal(Math.abs(x[1] - y[1]));
        return bigDecimaly.divide(bigDecimalx, 8, ROUND_UP);
    }

    private double calLen(int[] x, int[] y) {
        int abs1 = Math.abs(y[1] - x[1]);
        int abs2 = Math.abs(y[0] - x[0]);
        return Math.sqrt(Math.pow(abs1, 2) + Math.pow(abs2, 2));
    }

    public static void main(String[] args) {
        Code812 code812 = new Code812();
        code812.largestTriangleArea(new int[][]{
                {9,4},{5,8},{6,1}
        });
    }
}
