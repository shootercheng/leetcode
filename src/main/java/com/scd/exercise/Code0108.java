package com.scd.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code0108 {

    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowSet.contains(i)) {
                    matrix[i][j] = 0;
                }
                if (columnSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Code0108 code0108 = new Code0108();
        int[][] matrix = {{1,1,1},
                          {1,0,1},
                          {1,1,1}};
        code0108.setZeroes(matrix);
        System.out.println(matrix);
    }
}
