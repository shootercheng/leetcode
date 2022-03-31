package com.scd.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class CodeOffer39 {

    public int majorityElement(int[] nums) {
        int half = nums.length / 2;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            Integer count = countMap.computeIfAbsent(n, k -> 0);
            count++;
            if (count > half) {
                return n;
            }
            countMap.put(n, count);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,2,5,4,2};
        CodeOffer39 codeOffer39 = new CodeOffer39();
        codeOffer39.majorityElement(nums);
    }
}
