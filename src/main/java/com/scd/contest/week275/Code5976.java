package com.scd.contest.week275;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code5976 {

    public boolean checkValid(int[][] matrix) {
        int lenm = matrix.length;
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        for (int i = 0; i < lenm; i++) {
            for (int j = 0; j < lenm; j++) {
                Set<Integer> rowSet = rowMap.computeIfAbsent(i, k -> new HashSet<>());
                rowSet.add(matrix[i][j]);
                Set<Integer> colSet = colMap.computeIfAbsent(j, k -> new HashSet<>());
                colSet.add(matrix[i][j]);
            }
        }
        return checkMap(rowMap, lenm) && checkMap(colMap, lenm);
    }

    private boolean checkMap(Map<Integer, Set<Integer>> rowMap, int lenm) {
        Set<Map.Entry<Integer, Set<Integer>>> entrySet = rowMap.entrySet();
        for (Map.Entry<Integer, Set<Integer>> entry : entrySet) {
            Set<Integer> rowVal = entry.getValue();
            if (rowVal.size() != lenm) {
                return false;
            }
            for (int i = 1; i <= lenm; i++) {
                if (!rowVal.contains(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
