package com.scd.exercise.m10;

/**
 * @author James
 */
public class CodeOffer29 {

    public int[] spiralOrder(int[][] matrix) {
        int rowLen = matrix.length;
        for (int i = 0; i < rowLen; i++) {
            int[] rowArr = matrix[i];
            int colLen = rowArr.length;
            for (int j = 0; j < colLen; j++) {
                System.out.println(matrix[i][j]);
            }
        }
        return new int[]{1,2};
    }
}
