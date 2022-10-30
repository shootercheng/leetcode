package com.scd.exercise.y2022.m7.middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code2352 {

    public int equalPairs(int[][] grid) {
        Map<Integer, StringBuilder> rowMap = new HashMap<>();
        Map<Integer, StringBuilder> colMap = new HashMap<>();
        int leng = grid.length;
        for (int i = 0; i < leng; i++) {
            StringBuilder rowBuilder = rowMap.computeIfAbsent(i, k -> new StringBuilder());
            for (int j = 0; j < grid[i].length; j++) {
                rowBuilder.append(grid[i][j]).append("_");
                StringBuilder colBuilder = colMap.computeIfAbsent(j, k -> new StringBuilder());
                colBuilder.append(grid[i][j]).append("_");
            }
        }
        int count = 0;
        Set<String> repSet = new HashSet<>();
        for (Map.Entry<Integer, StringBuilder> rowEntry : rowMap.entrySet()) {
            for (Map.Entry<Integer, StringBuilder> colEntry : colMap.entrySet()) {
                Integer rowKey = rowEntry.getKey();
                Integer colKey = colEntry.getKey();
                String key = rowKey + "_" + colKey;
                if (!repSet.contains(key)) {
                    repSet.add(key);
                    if (rowEntry.getValue().toString().equals(colEntry.getValue().toString())) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid =  {{3,2,1},{1,7,6},{2,7,7}};
        Code2352 code2352 = new Code2352();
        code2352.equalPairs(grid);
    }
}
