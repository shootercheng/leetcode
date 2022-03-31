package com.scd.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class CodeOffer56 {

    public int[] singleNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.computeIfAbsent(num, k -> 0);
            countMap.put(num, ++count);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        int lenr = result.size();
        int[] retNum = new int[lenr];
        for (int i = 0; i < lenr; i++) {
            retNum[i] = result.get(i);
        }
        return retNum;
    }

    public int singleNumbers2(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            Integer count = countMap.computeIfAbsent(nums[i], k -> 0);
            countMap.put(nums[i], ++count);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,3,3};
        CodeOffer56 codeOffer56 = new CodeOffer56();
        codeOffer56.singleNumbers2(nums);
    }
}
