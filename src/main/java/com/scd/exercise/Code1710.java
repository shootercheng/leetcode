package com.scd.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code1710 {

    public int majorityElement(int[] nums) {
        int len = nums.length;
        int halfLen = len / 2;
        Map<Integer, Integer> intCountMap = new HashMap<>();
        for (int num : nums) {
            Integer count = intCountMap.computeIfAbsent(num, k -> new Integer(0));
            intCountMap.put(num, ++count);
            if (count > halfLen) {
                return num;
            }
        }
        return -1;
    }
}
