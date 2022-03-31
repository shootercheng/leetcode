package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : strs) {
            char[] inputArr = str.toCharArray();
            Arrays.sort(inputArr);
            String key = new String(inputArr);
            List<String> valList = groupMap.computeIfAbsent(key, k -> new ArrayList<>());
            valList.add(str);
        }
        return new ArrayList<>(groupMap.values());
    }
}
