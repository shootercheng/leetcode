package com.scd.book.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class ExIndexSum {

    public String[] findRestaurant(String[] list1, String[] list2) {
        int len1 = list1.length;
        int len2 = list2.length;
        if (len1 > len2) {
            return findSameRestaurant(list1, list2);
        } else {
            return findSameRestaurant(list2, list1);
        }
    }

    private String[] findSameRestaurant(String[] list1, String[] list2) {
        int len2 = list2.length;
        Map<String, Integer> strIndexMap = new HashMap<>(len2);
        for (int i = 0; i < len2; i++) {
            strIndexMap.put(list2[i], i);
        }
        int len1 = list1.length;
        int[] sumArr = new int[len1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len1; i++) {
            Integer index = strIndexMap.get(list1[i]);
            if (index != null) {
                sumArr[i] = i + index;
                if (sumArr[i] < min) {
                    min = sumArr[i];
                }
            } else {
                sumArr[i] = -1;
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            if (sumArr[i] == min) {
                result.add(list1[i]);
            }
        }
        String[] resultArr = new String[result.size()];
        result.toArray(resultArr);
        return resultArr;
    }
}
