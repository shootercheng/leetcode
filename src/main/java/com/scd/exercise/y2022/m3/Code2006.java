package com.scd.exercise.y2022.m3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 2006. 差的绝对值为 K 的数对数目
 * @author James
 */
public class Code2006 {

    public int countKDifference(int[] nums, int k) {
        Map<Integer, List<Integer>> mapIndexList = new HashMap<>();
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            List<Integer> indexList = mapIndexList.computeIfAbsent(nums[i], a -> new ArrayList<>());
            indexList.add(i);
        }
        Set<String> indexSet = new HashSet<>();
        int[] countArr = new int[1];
        for (int i = 0; i < lenn; i++) {
            int others = nums[i] + k;
            count(mapIndexList, indexSet, countArr, i, others);
            others = nums[i] - k;
            if (others > 0) {
                count(mapIndexList, indexSet, countArr, i, others);
            }
        }
        return countArr[0];
    }

    private void count(Map<Integer, List<Integer>> mapIndexList, Set<String> indexSet, int[] countArr, int i, int others) {
        List<Integer> indexList = mapIndexList.get(others);
        if (indexList != null) {
            for (int index : indexList) {
                if (index == i) {
                    continue;
                }
                String key =  i > index ? index + "_" + i : i + "_" + index;
                if (!indexSet.contains(key)) {
                    countArr[0]++;
                    indexSet.add(key);
                }
            }
        }
    }
}
