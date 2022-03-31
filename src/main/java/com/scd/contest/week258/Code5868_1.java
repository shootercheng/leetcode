package com.scd.contest.week258;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code5868_1 {

    public long interchangeableRectangles(int[][] rectangles) {
        int index = 0;
        Map<Double, List<Integer>> rateMap = new HashMap<>();
        for (int[] rect : rectangles) {
            Double key = calKey(rect);
            List<Integer> indexList = rateMap.computeIfAbsent(key, k -> new ArrayList<>());
            indexList.add(index);
            index++;
        }
        long result = 0;
        for (List<Integer> indexList : rateMap.values()) {
            long size = indexList.size();
            result = result + size * (size - 1) / 2;
        }
        return result;
    }

    public double calKey(int[] rArr) {
        int a = rArr[0];
        int b = rArr[1];
        return (double) a / b;
    }

}
