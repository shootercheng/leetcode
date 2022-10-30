package com.scd.exercise.y2022.m10.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 合并相似的物品
 */
public class Code2363 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int[] item : items1) {
            numMap.put(item[0], item[1]);
        }
        for (int[] item : items2) {
            numMap.merge(item[0], item[1], Integer::sum);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            List<Integer> item = new ArrayList<>();
            item.add(entry.getKey());
            item.add(entry.getValue());
            list.add(item);
        }
        list = list.stream().sorted(this::sort).collect(Collectors.toList());
        return list;
    }

    public int sort(List<Integer> val1, List<Integer> val2) {
        return val1.get(0) - val2.get(0);
    }
}
