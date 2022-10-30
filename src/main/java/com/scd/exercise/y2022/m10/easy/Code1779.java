package com.scd.exercise.y2022.m10.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找到最近的有相同的X或Y坐标的点
 */
public class Code1779 {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDis = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> disIndexMap = new HashMap<>();
        int index = 0;
        boolean isFind = false;
        for (int[] point : points) {
            if (point[0] == x || point[1] == y) {
                isFind = true;
                int dis = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                if (dis < minDis) {
                    minDis = dis;
                    List<Integer> indexList = disIndexMap.computeIfAbsent(dis, k -> new ArrayList<>());
                    indexList.add(index);
                }
            }
            index++;
        }
        if (!isFind) {
            return -1;
        }
        return disIndexMap.get(minDis).get(0);
    }
}
