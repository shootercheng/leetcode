package com.scd.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> eleMap = new LinkedHashMap<>();
        for (int i : arr2) {
            eleMap.put(i, 0);
        }
        Arrays.sort(arr1);
        for (int i : arr1) {
            Integer count = eleMap.get(i);
            if (count == null) {
                eleMap.put(i, 1);
            } else {
                eleMap.put(i, ++count);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = eleMap.entrySet();
        int[] result = new int[arr1.length];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : set) {
            Integer key = entry.getKey();
            Integer count = entry.getValue();
            for (int j = 0; j < count; j++) {
                result[i++] = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        Code1122 code1122 = new Code1122();
        int[]res = code1122.relativeSortArray(arr1, arr2);
        System.out.println(res);
    }
}
