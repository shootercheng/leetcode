package com.scd.contest.week258;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code5868 {

    public long interchangeableRectangles(int[][] rectangles) {
        int index = 0;
        Map<String, List<Integer>> rateMap = new HashMap<>();
        for (int[] rect : rectangles) {
            String key = calKey(rect);
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

    public String calKey(int[] rArr) {
        int a = rArr[0];
        int b = rArr[1];
        int gcd;
        if (a > b) {
            gcd = calGcd(a, b);
        } else {
            gcd = calGcd(b, a);
        }
        return a / gcd + "_" + b / gcd;
    }

    public int calGcd(int a, int b) {
        for (int i = b; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
