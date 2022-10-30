package com.scd.exercise.y2022.m6.easy;

/**
 * @author James
 */
public class Code6101 {

    public boolean checkXMatrix(int[][] grid) {
        int leng = grid.length;
        boolean[][] gridLine = new boolean[leng][leng];
        for (int i = 0; i < leng; i++) {
            if (grid[i].length != leng) {
                return false;
            }
            if (grid[i][i] == 0) {
                return false;
            }
            gridLine[i][i] = true;
        }
        for (int i = 0, j = leng - 1; i < leng; i++, j--) {
            if (grid[i][j] == 0) {
                return false;
            }
            gridLine[i][j] = true;
        }
        for (int i = 0; i < leng; i++) {
            for (int j = 0; j < leng; j++) {
                if (!gridLine[i][j]) {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private boolean bordRow(int i, int j, int[][] grid) {
        if (j == 0 || j == grid.length - 1) {
            if (grid[i][j] == 0) {
                return false;
            }
        } else {
            if (grid[i][j] != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean bordCol(int i, int j, int[][] grid) {
        if (i == 0 || i == grid.length - 1) {
            if (grid[i][j] == 0) {
                return false;
            }
        } else {
            if (grid[i][j] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{6,0,0,0,0,0,0,18},
                {0,17,0,0,0,0,18,0},
                {0,0,13,0,0,17,0,0},
                {0,0,0,9,18,0,0,0},
                {0,0,0,2,20,0,0,0},
                {0,0,20,0,0,3,0,0},
                {0,14,0,0,0,0,11,0},
                {19,0,0,0,0,0,0,9}};
        Code6101 code6101 = new Code6101();
        code6101.checkXMatrix(grid);
    }
}
