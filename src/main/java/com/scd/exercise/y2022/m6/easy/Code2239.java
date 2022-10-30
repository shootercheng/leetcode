package com.scd.exercise.y2022.m6.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code2239 {

    public int findClosestNumber(int[] nums) {
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        int minDis = Integer.MAX_VALUE;
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            int curDis = Math.abs(nums[i]);
            if (curDis < minDis) {
                minDis = curDis;
            }
            List<Integer> curNums = countMap.computeIfAbsent(curDis, k -> new ArrayList<>());
            curNums.add(curDis);
        }
        List<Integer> list = countMap.get(minDis)
                .stream().sorted().collect(Collectors.toList());
        return list.get(list.size() - 1);
    }
}
