package com.scd.exercise.y2021.m1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code1329 {

    public int[][] diagonalSort(int[][] mat) {
        int lenm = mat.length;
        for (int j = 0; j < mat[0].length; j++) {
            sortFirstRowOrColumn(mat, lenm, 0, j);
        }
        for (int k = 1; k < lenm; k++) {
            sortFirstRowOrColumn(mat, lenm, k, 0);
        }
        return mat;
    }

    private void sortFirstRowOrColumn(int[][] mat, int lenm, int i, int j) {
        List<int[]> indexList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();
        while (i < lenm && j < mat[i].length) {
            int[] oneIndex = new int[2];
            oneIndex[0] = i;
            oneIndex[1] = j;
            indexList.add(oneIndex);
            dataList.add(mat[i][j]);
            i++;
            j++;
        }
        sortDataList(indexList, dataList, mat);
    }

    private void sortDataList(List<int[]> indexList, List<Integer> dataList, int[][] mat) {
        if (dataList.size() == 1) {
            return ;
        }
        dataList = dataList.stream().sorted().collect(Collectors.toList());
        int leni = indexList.size();
        for (int i = 0; i < leni; i++) {
            int[] index = indexList.get(i);
            mat[index[0]][index[1]] = dataList.get(i);
        }
    }

    public static void main(String[] args) {
        Code1329 code1329 = new Code1329();
        int[][] mat1 = new int[][]{
                {3,3,1,1},
                {2,2,1,2},
                {1,1,1,2}
        };
        int[][] mat2 = new int[][]{
                {1},
                {2},
                {3}
        };
        code1329.diagonalSort(mat1);
    }
}
