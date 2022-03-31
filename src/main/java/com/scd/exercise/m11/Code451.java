package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code451 {
    public String frequencySort(String s) {
        char[] scharArr = s.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : scharArr) {
            Integer count = countMap.computeIfAbsent(c, k -> 0);
            countMap.put(c, ++count);
        }
        Map<Integer, List<Character>> countListMap = new HashMap<>();
        Set<Map.Entry<Character, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            List<Character> list = countListMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>());
            list.add(entry.getKey());
        }
        List<Integer> countList = countListMap.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer count : countList) {
            List<Character> list = countListMap.get(count);
            for (Character character : list) {
                appendStr(stringBuilder, character, count);
            }
        }
        return stringBuilder.toString();
    }

    private void appendStr(StringBuilder stringBuilder, Character character, Integer count) {
        for (int i = 0; i < count; i++) {
            stringBuilder.append(character);
        }
    }
}
