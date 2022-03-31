package com.scd.exercise.y2022.m3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 432. 全 O(1) 的数据结构
 * @author James
 */
public class Code432_1 {

    static class AllOne {

        private String maxKey;

        private String minKey;

        private Map<String, Integer> countMap;

        public AllOne() {
            maxKey = "";
            minKey = "";
            countMap = new HashMap<>();
        }

        public void inc(String key) {
            Integer count = countMap.computeIfAbsent(key, k -> 0);
            countMap.put(key, ++count);
            findMaxMin();
        }

        public void dec(String key) {
            Integer count = countMap.computeIfAbsent(key, k -> 0);
            count--;
            if (count == 0) {
                countMap.remove(key);
            } else {
                countMap.put(key, count);
            }
            findMaxMin();
        }

        public String getMaxKey() {
            return maxKey;
        }

        public String getMinKey() {
            return minKey;
        }

        private void findMaxMin() {
            if (countMap.size() == 0) {
                minKey = "";
                maxKey = "";
            }
            Set<Map.Entry<String, Integer>> entrySet = countMap.entrySet();
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> entry : entrySet) {
                int count = entry.getValue();
                if (count > max) {
                    max = count;
                    maxKey = entry.getKey();
                }
                if (count < min) {
                    min = count;
                    minKey = entry.getKey();
                }
            }
        }
    }

    public static void main(String[] args) {
//        ["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
//            [[],["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]
        AllOne code432 = new AllOne();
//        String[] arr = {"inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"};
//        for (String str : arr) {
//            System.out.println("code432." + str + "(\"\");");
//        }
        code432.inc("a");
        code432.inc("b");
        code432.inc("b");
        code432.inc("c");
        code432.inc("c");
        code432.inc("c");
        code432.dec("b");
        code432.dec("b");
        code432.getMinKey();
        code432.dec("a");
        code432.getMaxKey();
        code432.getMinKey();
    }
}
