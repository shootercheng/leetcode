package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code378 {

    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> dataList = new ArrayList<>();
        int lenm = matrix.length;
        for (int i = 0; i < lenm; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dataList.add(matrix[i][j]);
            }
        }
        dataList = dataList.stream().sorted().collect(Collectors.toList());
        return dataList.get(k - 1);
    }
}
