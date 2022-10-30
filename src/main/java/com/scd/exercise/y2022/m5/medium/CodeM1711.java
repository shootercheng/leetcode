package com.scd.exercise.y2022.m5.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class CodeM1711 {

    public int findClosest(String[] words, String word1, String word2) {
        Map<String, List<Integer>> wordIndexMap = new HashMap<>();
        int lenw = words.length;
        for (int i = 0; i < lenw; i++) {
            List<Integer> indexList = wordIndexMap.computeIfAbsent(words[i], k -> new ArrayList<>());
            indexList.add(i);
        }
        List<Integer> indexList1 = wordIndexMap.get(word1);
        List<Integer> indexList2 = wordIndexMap.get(word2);
        if (indexList1 == null || indexList2 == null) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int num1 : indexList1) {
            for (int num2 : indexList2) {
                int abs = Math.abs(num2 - num1);
                if (abs < min) {
                    min = abs;
                }
            }
        }
        return min;
    }
}
