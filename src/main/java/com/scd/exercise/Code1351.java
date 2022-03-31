package com.scd.exercise;

/**
 * @author James
 */
public class Code1351 {

    public int countNegatives(int[][] grid) {
        int len = grid.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
