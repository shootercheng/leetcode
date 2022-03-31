package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code1582 {

    public int numSpecial(int[][] mat) {
        Map<Integer, List<Integer>> rowData = new HashMap<>();
        Map<Integer, List<Integer>> colData = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                List<Integer> rowList = rowData.computeIfAbsent(i, k -> new ArrayList<>());
                rowList.add(mat[i][j]);
                List<Integer> colList = colData.computeIfAbsent(j, k -> new ArrayList<>());
                colList.add(mat[i][j]);
            }
        }
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    List<Integer> rowList = rowData.get(i);
                    List<Integer> colList = colData.get(j);
                    if (isRightList(rowList, j) && isRightList(colList, i)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isRightList(List<Integer> list, int j) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i != j && list.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,0,0}, {0,0,1}, {1,0,0}};
        Code1582 code1582 = new Code1582();
        System.out.println(code1582.numSpecial(mat));
    }
}
