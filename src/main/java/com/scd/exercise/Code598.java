package com.scd.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code598 {

    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return 0;
        }
        int[][] martix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                martix[i][j] = 0;
            }
        }
        int lenops = ops.length;
        int[] maxArr = new int[1];
        for (int i = 0; i < lenops; i++) {
            int[] value = ops[i];
            addRowColumn(martix, value[0], value[1], maxArr);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (martix[i][j] == maxArr[0]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void addRowColumn(int[][] martix, int row, int column, int[] maxArr) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                martix[i][j]++;
                if (martix[i][j] > maxArr[0]) {
                    maxArr[0] = martix[i][j];
                }
            }
        }
    }
}
