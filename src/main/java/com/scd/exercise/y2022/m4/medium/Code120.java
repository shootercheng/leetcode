package com.scd.exercise.y2022.m4.medium;

import java.util.List;

/**
 * 120 *三角形最小路径和
 * @author James
 */
public class Code120 {

    /**
     *  (=======动态规划)
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int lent = triangle.size();
        int[][] record = new int[lent][lent];
        record[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < lent; i++) {
            // 最左侧
            record[i][0] = record[i-1][0] + triangle.get(i).get(0);
            // 中间
            int right = triangle.get(i).size() - 1;
            for (int j = 1; j < right; j++) {
                // 上一行向下移动
                int pathLen1 = record[i - 1][j] + triangle.get(i).get(j);
                // 上一行向下、向右移动
                int pathLen2 = record[i - 1][j - 1] + triangle.get(i).get(j);
                record[i][j] = Math.min(pathLen1, pathLen2);
            }
            // 最右侧
            record[i][right] = record[i - 1][triangle.get(i - 1).size() - 1] + triangle.get(i).get(right);
        }
        int min = record[lent - 1][0];
        for (int i = 1; i < lent; i++) {
            if (record[lent - 1][i] < min) {
                min = record[lent - 1][i];
            }
        }
        return min;
    }
}
