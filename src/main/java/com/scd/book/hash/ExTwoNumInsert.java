package com.scd.book.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class ExTwoNumInsert {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap1 = createCountMap(nums1);
        Map<Integer, Integer> countMap2 = createCountMap(nums2);
        Set<Map.Entry<Integer, Integer>> entrySet = countMap1.entrySet();
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            int key = entry.getKey();
            Integer count = countMap2.get(key);
            if (count != null) {
                int loop;
                if (entry.getValue() > count) {
                    loop = count;
                } else {
                    loop = entry.getValue();
                }
                for (int i = 0; i < loop; i++) {
                    result.add(key);
                }
            }
        }
        int lenr = result.size();
        int[] resArr = new int[lenr];
        for (int i = 0; i < lenr; i++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }

    private Map<Integer, Integer> createCountMap(int[] num) {
        Map<Integer, Integer> countMap = new HashMap<>(16);
        for (Integer n : num) {
            Integer count = countMap.computeIfAbsent(n, k -> 0);
            countMap.put(n, ++count);
        }
        return countMap;
    }
}
