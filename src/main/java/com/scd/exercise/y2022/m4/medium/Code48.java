package com.scd.exercise.y2022.m4.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 48. 旋转图像
 * @author James
 */
public class Code48 {

    public void rotate(int[][] matrix) {
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        int lenm = matrix.length;
        for (int i = 0; i < lenm; i++) {
            for (int j = 0; j < lenm; j++) {
                List<Integer> colList = colMap.computeIfAbsent(j, k -> new ArrayList<>());
                colList.add(matrix[i][j]);
            }
        }
        for (int i = 0; i < lenm; i++) {
            List<Integer> colList = colMap.get(i);
            int col = 0;
            for (int j = colList.size() - 1; j >= 0; j--) {
                matrix[i][col++] = colList.get(j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        Code48 code48 = new Code48();
        code48.rotate(nums);
    }
}
