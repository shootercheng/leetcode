package com.scd.exercise.y2022.m9.middle;

public class Code2428 {
    public int maxSum(int[][] grid) {
        int gRow = grid.length;
        int gCol = grid[0].length;
        int maxSum = 0;
        for (int i = 0; i <= gRow - 3; i++) {
            for (int j = 0; j <= gCol - 3; j++) {
                int curSum = sumOne(i, j, grid);
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
            }
        }
        return maxSum;
    }

    private int sumOne(int startRow, int startCol, int[][] grid) {
        int sum = 0;
        for (int i = startRow; i <= startRow + 2; i++) {
            for (int j = startCol; j <= startCol + 2; j++) {
                if (i == startRow + 1 && (j == startCol || j == startCol + 2)) {
                    continue;
                }
                sum = sum + grid[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Code2428 code2428 = new Code2428();
        int[][] grid = {{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}};
        code2428.maxSum(grid);
    }
}
