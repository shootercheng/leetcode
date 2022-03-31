package com.scd.exercise;

/**
 * @author James
 */
public class Code1252 {

    public int oddCells(int n, int m, int[][] indices) {
        int[][] martix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                martix[i][j] = 0;
            }
        }
        int len = indices.length;
        for (int i = 0; i < len; i++) {
            int[] curRow = indices[i];
            addRow(martix, curRow[0]);
            addColumn(martix, curRow[1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (martix[i][j] % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private void addRow(int[][] martix, int row) {
        int[] curRow = martix[row];
        int len = curRow.length;
        for (int i = 0; i < len; i++) {
            curRow[i]++;
        }
    }

    private void addColumn(int[][] martix, int column) {
        int len = martix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < martix[i].length; j++) {
                if (j == column) {
                    martix[i][j]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 2;
        int m = 2;
        int[][] indices = {{1,1},{0,0}};
        Code1252 code1252 = new Code1252();
        int result = code1252.oddCells(n, m, indices);
        System.out.println(result);
    }
}
