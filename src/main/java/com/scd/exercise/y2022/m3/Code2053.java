package com.scd.exercise.y2022.m3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 2053. 数组中第 K 个独一无二的字符串
 * @author James
 */
public class Code2053 {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> countMap = new LinkedHashMap<>();
        for (String str : arr) {
            Integer num = countMap.computeIfAbsent(str, a -> 0);
            countMap.put(str, ++num);
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
            }
            if (count == k) {
                return entry.getKey();
            }
        }
        return "";
    }
}
