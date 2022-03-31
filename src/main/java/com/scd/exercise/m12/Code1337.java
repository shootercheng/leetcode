package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code1337 {

    class SolNum {
        private int row;

        private int num;

        public SolNum(int row, int num) {
            this.row = row;
            this.num = num;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int lenm = mat.length;
        List<SolNum> solList = new ArrayList<>();
        for (int i = 0; i < lenm; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            SolNum solNum = new SolNum(i, count);
            solList.add(solNum);
        }
        solList = solList.stream().sorted(Comparator.comparingInt(this::sortRow)).collect(Collectors.toList());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = solList.get(i).row;
        }
        return result;
    }

    private int sortRow(SolNum solNum) {
        return solNum.num;
    }
}
