package com.scd.contest.week237;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code5736 {

    public int[] getOrder(int[][] tasks) {
        Map<Integer, List<Integer>> timeTaskMap = new HashMap<>();
        List<Integer> timeList = new ArrayList<>();
        for (int[] task : tasks) {
            List<Integer> taskSeqList = timeTaskMap.computeIfAbsent(task[0], k -> new ArrayList<>());
            taskSeqList.add(task[1]);
            timeList.add(task[0]);
        }
        List<Integer> sortedList = timeList.stream().sorted().collect(Collectors.toList());
        for (Integer time : sortedList) {

        }
        return new int[3];
    }
}
