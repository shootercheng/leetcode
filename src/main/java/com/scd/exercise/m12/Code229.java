package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code229 {

    public List<Integer> majorityElement(int[] nums) {
        int lenn = nums.length;
        int thresHold;
        boolean mod = false;
        if (lenn % 3 == 0) {
            mod = true;
            thresHold = lenn / 3;
        } else {
            thresHold = lenn / 3 + 1;
        }
        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> numsCountMap = new HashMap<>();
        for (int num : nums) {
            Integer count = numsCountMap.computeIfAbsent(num, k -> 0);
            numsCountMap.put(num, ++count);
            if (mod) {
                if (count > thresHold) {
                    result.add(num);
                }
            } else {
                if (count >= thresHold) {
                    result.add(num);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Code229 code229 = new Code229();
        System.out.println(code229.majorityElement(nums));
    }
}
