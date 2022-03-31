package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
        List<List<Integer>> resultList = new ArrayList<>();
        int len = groupSizes.length;
        for (int i = 0; i < len; i++) {
            List<Integer> indexList = numIndexMap.computeIfAbsent(groupSizes[i], k -> new ArrayList<>());
            if (indexList.size() >= groupSizes[i]) {
                resultList.add(new ArrayList<>(indexList));
                indexList.clear();
            }
            indexList.add(i);
        }
        for (List<Integer> list : numIndexMap.values()) {
            resultList.add(list);
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] groupSize = {3,3,3,3,3,1,3};
        Code1282 code1282 = new Code1282();
        List<List<Integer>> resultList = code1282.groupThePeople(groupSize);
        System.out.println(resultList);
    }
}
