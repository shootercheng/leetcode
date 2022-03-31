package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int lenm = matrix.length;
        for (int i = 0; i < lenm; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int cur = matrix[i][j];
                if (i + 1 < lenm && j + 1 < matrix[i+1].length) {
                    int next = matrix[i+1][j+1];
                    if (cur != next) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
