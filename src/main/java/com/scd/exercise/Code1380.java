package com.scd.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code1380 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        int lenm = matrix.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lenm; i++) {
            int[] row = matrix[i];
            int index = findMinIndex(row);
            if (isMaxColumn(matrix, i, index, lenm)) {
                result.add(matrix[i][index]);
            }
        }
        return result;
    }

    private boolean isMaxColumn(int[][] matrix, int curRow, int index, int lenm) {
        for (int i = 0; i < lenm; i++) {
            if (i != curRow && matrix[i][index] > matrix[curRow][index]) {
                return false;
            }
        }
        return true;
    }

    private int findMinIndex(int[] row) {
        int rlen = row.length;
        int min = row[0];
        int minIndex = 0;
        for (int i = 1; i < rlen; i++) {
            if (row[i] < min) {
                min = row[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
