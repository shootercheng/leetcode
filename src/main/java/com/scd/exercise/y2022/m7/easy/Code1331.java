package com.scd.exercise.y2022.m7.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code1331 {

    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> numMap = new HashMap<>();
        int lena = arr.length;
        for (int i = 0; i < lena; i++) {
            List<Integer> indexList = numMap.computeIfAbsent(arr[i], k -> new ArrayList<>());
            indexList.add(i);
        }
        List<Map.Entry<Integer, List<Integer>>> entryList = numMap.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry<Integer, List<Integer>>::getKey))
                .collect(Collectors.toList());
        int[] result = new int[lena];
        int order = 1;
        for (Map.Entry<Integer, List<Integer>> entry : entryList) {
            List<Integer> indexList = entry.getValue();
            for (Integer index : indexList) {
                result[index] = order;
            }
            order++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {40,10,20,30};
        Code1331 code1331 = new Code1331();
        code1331.arrayRankTransform(arr);
    }
}
