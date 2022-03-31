package com.scd.exercise.y2021.m1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code1128 {

    public int numEquivDominoPairs(int[][] dominoes) {
        int lend = dominoes.length;
        Map<String, List<Integer>> dataIndexList = new HashMap<>();
        for (int i = 0; i < lend; i++) {
            String key = dominoes[i][0] > dominoes[i][1] ? dominoes[i][0] + "_" + dominoes[i][1] :
                    dominoes[i][1] + "_" + dominoes[i][0];
            List<Integer> indexList = dataIndexList.computeIfAbsent(key, k -> new ArrayList<>());
            indexList.add(i);
        }
        int count = 0;
        Set<Map.Entry<String, List<Integer>>> entrySet = dataIndexList.entrySet();
        for (Map.Entry<String, List<Integer>> entry : entrySet) {
            int size = entry.getValue().size();
            if (size > 1) {
                count = count + calCombine(size);
            }
        }
        return count;
    }

    public int calCombine(int m) {
        return m * (m - 1) / 2;
    }

    public static void main(String[] args) {
        Map<int[], List<Integer>> dataIndexList = new HashMap<>();
        List<Integer> indexList = new ArrayList<>();
        dataIndexList.put(new int[]{1,1}, indexList);
        indexList.add(1);
        int[] inputData = new int[]{1,1};
        System.out.println(dataIndexList.containsKey(inputData));
        System.out.println(dataIndexList);
        Code1128 code1128 = new Code1128();
        System.out.println(code1128.calCombine(3));
        System.out.println(code1128.calCombine(2));
    }
}
