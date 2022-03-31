package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        List<Integer> dataList = new ArrayList<>();
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                dataList.add(nums[i][j]);
            }
        }
        int sum = r * c;
        if (sum != dataList.size()) {
            return nums;
        }
        int[][] result = new int[r][c];
        int dataIndex = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = dataList.get(dataIndex++);
            }
        }
        return result;
    }
}
