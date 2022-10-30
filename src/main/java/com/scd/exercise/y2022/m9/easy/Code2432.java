package com.scd.exercise.y2022.m9.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code2432 {

    public int hardestWorker(int n, int[][] logs) {
        int len = logs.length;
        Map<Integer, List<Integer>> timeIdMap = new HashMap<>();
        int maxTime = logs[0][1];
        List<Integer> idList = timeIdMap.computeIfAbsent(maxTime, k -> new ArrayList<>());
        idList.add(logs[0][0]);
        for (int i = 0; i < len - 1; i++) {
            int[] cur = logs[i];
            int[] next = logs[i+1];
            int curTime = next[1] - cur[1];
            List<Integer> ids = timeIdMap.computeIfAbsent(curTime, k -> new ArrayList<>());
            ids.add(logs[i+1][0]);
            if (curTime > maxTime) {
                maxTime = curTime;
            }
        }
        List<Integer> maxTimeIdList = timeIdMap.get(maxTime);
        if (maxTimeIdList.size() == 1) {
            return maxTimeIdList.get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int id : maxTimeIdList) {
            if (id < min) {
                min = id;
            }
        }
        return min;
    }
}
