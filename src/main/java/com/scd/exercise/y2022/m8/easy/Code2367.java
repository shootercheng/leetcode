package com.scd.exercise.y2022.m8.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code2367 {

    public int arithmeticTriplets(int[] nums, int diff) {
        Map<Integer, Integer> map = new HashMap<>();
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            map.put(nums[i], i);
        }
        int count = 0;
        for (int i = 0; i < lenn; i++) {
            int first = nums[i];
            int second = first + diff;
            int thrid = second + diff;
            if (map.containsKey(second) && map.containsKey(thrid)) {
                count++;
            }
        }
        return count;
    }
}
