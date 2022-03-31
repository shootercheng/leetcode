package com.scd.exercise.m12;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code73 {

    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int lenm = matrix.length;
        for (int i = 0; i < lenm; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < lenm; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
