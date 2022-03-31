package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class MCode1711 {
    public int findClosest(String[] words, String word1, String word2) {
        Map<String, List<Integer>> wordIndexMap = new HashMap<>();
        int lenw = words.length;
        for (int i = 0; i < lenw; i++) {
            List<Integer> indexList = wordIndexMap.computeIfAbsent(words[i], k -> new ArrayList<>());
            indexList.add(i);
        }
        List<Integer> list1 = wordIndexMap.get(word1);
        List<Integer> list2 = wordIndexMap.get(word2);
        int minDis = Integer.MAX_VALUE;
        for (Integer i : list1) {
            for (Integer j : list2) {
                int dis = Math.abs(i - j);
                if (dis == 1) {
                    return 1;
                }
                if (dis < minDis) {
                    minDis = dis;
                }
            }
        }
        return minDis;
    }
}
