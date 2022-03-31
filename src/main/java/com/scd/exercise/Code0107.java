package com.scd.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code0107 {

    public void rotate(int[][] matrix) {
        int martixLen = matrix.length;
        Map<Integer, List<Integer>> rowListMap = new HashMap<>(martixLen);
        for (int i = 0; i < martixLen; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                List<Integer> list = rowListMap.computeIfAbsent(j, k -> new ArrayList<>(martixLen));
                list.add(matrix[i][j]);
            }
        }
        Set<Map.Entry<Integer, List<Integer>>> entrySet = rowListMap.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entrySet) {
            int rowNum = entry.getKey();
            List<Integer> list = entry.getValue();
            int j = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                matrix[rowNum][j++] = list.get(i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = { {1,2,3},
                          {4,5,6},
                          {7,8,9}
                        };
        Code0107 code0107 = new Code0107();
        code0107.rotate(input);
        System.out.println(input);
    }
}
