package com.scd.exercise.y2021.m1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code5653 {

    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        Map<Integer, Integer> edgeCountMap = new HashMap<>();
        for (int[] rectangle : rectangles) {
            int edge = Math.min(rectangle[0], rectangle[1]);
            if (edge > maxLen) {
                maxLen = edge;
            }
            Integer count = edgeCountMap.computeIfAbsent(edge, k -> 0);
            edgeCountMap.put(edge, ++count);
        }
        return edgeCountMap.get(maxLen);
    }
}
