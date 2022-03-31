package com.scd.exercise.y2021.m3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code1748 {

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int sum = 0;
        for (int num : nums) {
            Integer count = countMap.get(num);
            if (count == null) {
                countMap.put(num, 1);
                sum = sum + num;
            } else if (count == 1) {
                sum = sum - num;
                countMap.put(num, 0);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Code1748 code1748 = new Code1748();
        System.out.println(code1748.sumOfUnique(new int[]{1,1,2,2,3}));
    }
}
