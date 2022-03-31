package com.scd.exercise.y2022.m3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code599_1 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> wordMap = new HashMap<>();
        int lenl = list1.length;
        for (int i = 0; i < lenl; i++) {
            wordMap.put(list1[i], i);
        }
        int lenl2 = list2.length;
        int min = Integer.MAX_VALUE;
        Map<Integer, List<String>> resMap = new HashMap<>();
        for (int i = 0; i < lenl2; i++) {
            Integer index = wordMap.get(list2[i]);
            if (index != null) {
                int sum = index + i;
                if (sum <= min) {
                    min = sum;
                    List<String> words = resMap.computeIfAbsent(min, k -> new ArrayList<>());
                    words.add(list2[i]);
                }
            }
        }
        List<String> res = resMap.get(min);
        String[] result = new String[res.size()];
        int lenr = res.size();
        for (int i = 0; i < lenr; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
