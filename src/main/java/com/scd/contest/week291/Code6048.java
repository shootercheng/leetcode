package com.scd.contest.week291;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code6048 {

    public int minimumCardPickup(int[] cards) {
        Map<Integer, List<Integer>> numIndexList = new HashMap<>();
        int lenc = cards.length;
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < lenc; i++) {
            List<Integer> indexList = numIndexList.computeIfAbsent(cards[i], k -> new ArrayList<>());
            if (indexList.size() > 0) {
                int curDis = i - indexList.get(indexList.size() - 1) + 1;
                if (curDis < minDis) {
                    minDis = curDis;
                }
            }
            indexList.add(i);
        }
        if (minDis != Integer.MAX_VALUE) {
            return minDis;
        }
        return -1;
    }
}
