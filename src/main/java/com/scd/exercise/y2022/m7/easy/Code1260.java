package com.scd.exercise.y2022.m7.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 二维网格迁移
 * @author James
 */
public class Code1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (int i = 0; i < k; i++) {
            shiftOnce(grid);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> rowList = new ArrayList<>();
            for (int i = 0; i < row.length; i++) {
                rowList.add(row[i]);
            }
            result.add(rowList);
        }
        return result;
    }

    private void shiftOnce(int[][] grid) {
        int leng = grid.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < leng; i++) {
            list.add(grid[i][grid[i].length - 1]);
            for (int j = grid[i].length - 1; j > 0; j--) {
                grid[i][j] = grid[i][j - 1];
            }
        }
        int lenl = list.size();
        grid[0][0] = list.get(list.size() - 1);
        for (int i = 0; i < lenl - 1; i++) {
            grid[i+1][0] = list.get(i);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        Code1260 code1260 = new Code1260();
        code1260.shiftGrid(grid, 1);
    }
}
