package com.scd.exercise.y2022.m9.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Code2423 {

    public boolean equalFrequency(String word) {
        char[] wordArr = word.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>(16);
        for (Character ch : wordArr) {
            Integer count = countMap.computeIfAbsent(ch, k -> 0);
            countMap.put(ch, ++count);
        }
        if (countMap.size() == 1) {
            return true;
        }
        List<Integer> listSort = countMap.values().stream().sorted().collect(Collectors.toList());
        Map<Integer, List<Integer>> groupMap = listSort.stream().collect(Collectors.groupingBy(Integer::intValue));
        int size = groupMap.size();
        Integer first = listSort.get(0);
        Integer last = listSort.get(listSort.size() - 1);
        if (size == 1 && first == 1) {
            return true;
        }
        if (size == 2) {
            int lessCount = groupMap.get(first).size();
            int maxCount = groupMap.get(last).size();
            if (lessCount == 1 && first == 1) {
                return true;
            }
            if (maxCount == 1 && last == first + 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code2423 code2423 = new Code2423();
        System.out.println(code2423.equalFrequency("abc"));
    }
}
