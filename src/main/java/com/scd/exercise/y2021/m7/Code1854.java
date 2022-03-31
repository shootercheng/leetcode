package com.scd.exercise.y2021.m7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code1854 {

    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> yearCountMap = new HashMap<>();
        Map<Integer, List<Integer>> countYearListMap = new HashMap<>();
        int max = -1;
        for (int[] log : logs) {
            int start = log[0];
            int end = log[1];
            for (int y = start; y < end; y++) {
                int count = yearCountMap.computeIfAbsent(y, k -> 0);
                yearCountMap.put(y, ++count);
                if (count >= max) {
                    max = count;
                    List<Integer> list = countYearListMap.computeIfAbsent(count, k -> new ArrayList<>());
                    list.add(y);
                }
            }
        }
        List<Integer> yearList = countYearListMap.get(max);
        yearList = yearList.stream().sorted().collect(Collectors.toList());
        return yearList.get(0);
    }

    public static void main(String[] args) {
        int[][] logs = {{1950,1961},{1960,1971},{1970,1981}};
        Code1854 code1854 = new Code1854();
        System.out.println(code1854.maximumPopulation(logs));
    }
}
