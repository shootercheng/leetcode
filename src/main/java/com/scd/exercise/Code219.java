package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> eleListMap = new HashMap<>();
        int lenNum = nums.length;
        for (int i = 0; i < lenNum; i++) {
            List<Integer> indexList = eleListMap.computeIfAbsent(nums[i], l -> new ArrayList<>());
            indexList.add(i);
        }
        Set<Map.Entry<Integer, List<Integer>>> entrySet = eleListMap.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entrySet) {
            List<Integer> indexList = entry.getValue();
            if (isNearBy(indexList, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNearBy(List<Integer> indexList, int k) {
        if (indexList.size() < 2) {
            return false;
        }
        int size = indexList.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i+1; j < size; j++) {
//                System.out.println(i + "_" + j);
                if (Math.abs(indexList.get(i) - indexList.get(j)) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> indexList = Arrays.asList(1,3,5,7,9);
        Code219 code219 = new Code219();
        code219.isNearBy(indexList, 0);
        int[] inputNum= {1,2,3,1,2,3};
        System.out.println(code219.containsNearbyDuplicate(inputNum, 2));
    }
}
