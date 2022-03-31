package com.scd.exercise.m12;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int leng = grid.length;
        Map<Integer, Integer> rowMax = new HashMap<>();
        Map<Integer, Integer> colMax = new HashMap<>();
        for (int i = 0; i < leng; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Integer oldRowVal = rowMax.get(i);
                if (oldRowVal == null) {
                    rowMax.put(i, grid[i][j]);
                } else {
                    if (grid[i][j] > oldRowVal) {
                        rowMax.put(i, grid[i][j]);
                    }
                }
                Integer oldColVal = colMax.get(j);
                if (oldColVal == null) {
                    colMax.put(j, grid[i][j]);
                } else {
                    if (grid[i][j] > oldColVal){
                        colMax.put(j, grid[i][j]);
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < leng; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int growHeight = Math.min(rowMax.get(i), colMax.get(j)) - grid[i][j];
                sum = sum + growHeight;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {3,0,8,4},
                {2,4,5,7},
                {9,2,6,3},
                {0,3,1,0}
        };
        Code807 code807 = new Code807();
        System.out.println(code807.maxIncreaseKeepingSkyline(grid));
    }
}
