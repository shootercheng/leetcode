package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code914 {

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> groupMap = new HashMap<>();
        for (int i : deck) {
            Integer count = groupMap.computeIfAbsent(i, k -> 0);
            groupMap.put(i, ++count);
        }
        int min = Integer.MAX_VALUE;
        Set<Map.Entry<Integer, Integer>> entrySet = groupMap.entrySet();
        List<Integer> countList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            int count = entry.getValue();
            if (count == 1) {
                return false;
            }
            if (count < min) {
                min = count;
            }
            countList.add(count);
        }
        // 从最小分租2开始找
        for (int i = 2; i <= min; i++) {
            boolean hasGroup = true;
            for (Integer count : countList) {
                if (count % i != 0) {
                    hasGroup = false;
                }
            }
            if (hasGroup) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] deck = new int[]{1,1,1,1,2,2,2,2,2,2};
        Code914 code914 = new Code914();
        code914.hasGroupsSizeX(deck);
    }
}
