package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        if (m == 0) {
            return new ArrayList<>();
        }
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = grid[i][j];
                if (i == m - 1 && j == n - 1) {

                } else if (j == n -1) {

                } else {

                }
            }
        }
        return new ArrayList<>();
    }
}
