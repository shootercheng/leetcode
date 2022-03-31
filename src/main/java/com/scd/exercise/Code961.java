package com.scd.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code961 {

    public int repeatedNTimes(int[] A) {
        int lena = A.length;
        int num = lena / 2;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : A) {
            Integer count = countMap.computeIfAbsent(i, k -> 0);
            count = count + 1;
            if (count == num) {
                return i;
            }
            countMap.put(i, count);
        }
        return 0;
    }
}
