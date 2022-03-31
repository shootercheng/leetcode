package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code697 {

    public int findShortestSubArray(int[] nums) {
        int lenn = nums.length;
        Map<Integer, Integer> numMap = new HashMap<>();
        Map<Integer, List<Integer>> indexListMap = new HashMap<>();
        for (int i = 0; i < lenn; i++) {
            Integer count = numMap.computeIfAbsent(nums[i], k -> 0);
            numMap.put(nums[i], ++count);
            List<Integer> indexList = indexListMap.computeIfAbsent(nums[i], k -> new ArrayList<>());
            indexList.add(i);
        }
        int max = Integer.MIN_VALUE;
        Set<Map.Entry<Integer, Integer>> entrySet = numMap.entrySet();
        Map<Integer, List<Integer>> maxNumMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value >= max) {
                max = value;
                List<Integer> numList = maxNumMap.computeIfAbsent(max, k -> new ArrayList<>());
                numList.add(key);
            }
        }
        List<Integer> maxList = maxNumMap.get(max);
        int min = Integer.MAX_VALUE;
        for (Integer maxNum : maxList) {
            List<Integer> indexList = indexListMap.get(maxNum);
            if (indexList.size() > 1) {
                int dis = indexList.get(indexList.size() - 1) - indexList.get(0);
                if (dis < min) {
                    min = dis;
                }
            }
        }
        if (min != Integer.MAX_VALUE) {
            min = min + 1;
        } else {
            min = 1;
        }
        return min;
    }

    public static void main(String[] args) {
        Code697 code697 = new Code697();
        System.out.println(code697.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }
}
