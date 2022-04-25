package com.scd.exercise.y2022.m4.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class CodeOffer006 {

    public int[] twoSum(int[] numbers, int target) {
        int lenn = numbers.length;
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < lenn; i++) {
            numIndexMap.put(numbers[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < lenn; i++) {
            int other = target - numbers[i];
            Integer index = numIndexMap.get(other);
            if (index != null && index != i) {
                if (i < index) {
                    result[0] = i;
                    result[1] = index;
                } else {
                    result[0] = index;
                    result[1] = i;
                }
                break;
            }
        }
        return result;
    }
}
