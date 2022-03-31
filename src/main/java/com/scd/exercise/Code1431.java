package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        int len = candies.length;
        for (int i = 0; i < len; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        List<Boolean> resultList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (candies[i] + extraCandies >= max) {
                resultList.add(true);
            } else {
                resultList.add(false);
            }
        }
        return resultList;
    }
}
