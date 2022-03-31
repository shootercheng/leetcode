package com.scd.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code867 {

    public int[][] transpose(int[][] A) {
        int lena = A.length;
        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        for (int i = 0; i < lena; i++) {
            for (int j = 0; j < A[i].length; j++) {
                List<Integer> list = columnMap.computeIfAbsent(j, k -> new ArrayList<>());
                list.add(A[i][j]);
            }
        }
        int column = A[0].length;
        int[][] result = new int[column][lena];
        Set<Map.Entry<Integer, List<Integer>>> entrySet = columnMap.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entrySet) {
            int row = entry.getKey();
            List<Integer> rowValList = entry.getValue();
            int size = rowValList.size();
            for (int i = 0; i < size; i++) {
                result[row][i] = rowValList.get(i);
            }
        }
        return result;
    }
}
