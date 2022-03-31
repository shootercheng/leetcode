package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, List<Integer>> wordIndexMap = new HashMap<>();
        addIndex(list1, wordIndexMap);
        addIndex(list2, wordIndexMap);
        int min = Integer.MAX_VALUE;
        Set<Map.Entry<String, List<Integer>>> entrySet = wordIndexMap.entrySet();
        Map<String, Integer> wordIndexSum = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : entrySet) {
            List<Integer> indexList = entry.getValue();
            if (indexList.size() == 2) {
                int sum = indexList.get(0) + indexList.get(1);
                if (sum < min) {
                    min = sum;
                }
                wordIndexSum.put(entry.getKey(), sum);
            }
        }
        List<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordIndexSum.entrySet()) {
            if (entry.getValue() == min) {
                resultList.add(entry.getKey());
            }
        }
        int rSize = resultList.size();
        String[] resultArr = new String[rSize];
        for (int i = 0; i < rSize; i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }

    public void addIndex(String[] list, Map<String, List<Integer>> wordIndexMap) {
        int lenlist1 = list.length;
        for (int i = 0; i < lenlist1; i++) {
            List<Integer> indexList = wordIndexMap.computeIfAbsent(list[i], k -> new ArrayList<>());
            indexList.add(i);
        }
    }
}
