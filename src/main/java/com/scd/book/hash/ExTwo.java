package com.scd.book.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 只出现一次的数字
 * @author James
 */
public class ExTwo {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int count = countMap.computeIfAbsent(num, k -> 0);
            countMap.put(num, ++count);
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

    }
}
