package com.scd.exercise.y2022.m3;

import java.util.HashMap;
import java.util.Map;

/**
 * 432. 全 O(1) 的数据结构
 * @author James
 */
public class Code432 {

    class AllOne {

        private String maxKey;

        private int maxKeyCount;

        private String secondMaxKey;

        private int secondMaxKeyCount;

        private String minKey;

        private int minKeyCount;

        private String secondMinKey;

        private int secondMinKeyCount;

        private Map<String, Integer> countMap;

        public AllOne() {
            maxKey = "";
            maxKeyCount = 0;
            secondMaxKeyCount = 0;
            minKey = "";
            minKeyCount = 0;
            secondMinKeyCount = 0;
            countMap = new HashMap<>();
        }

        public void inc(String key) {
            if (maxKeyCount == 0) {
                maxKey = key;
                maxKeyCount = 1;
            }
            if (minKeyCount == 0) {
                minKey = key;
                minKeyCount = 1;
            }
            Integer count = countMap.get(key);
            if (count == null) {
                countMap.put(key, 0);
            } else {
                count++;
                if (count > maxKeyCount) {
                    maxKeyCount = count;
                    maxKey = key;
                } else if (count > secondMaxKeyCount) {
                    secondMaxKeyCount = count;
                    secondMaxKey = key;
                }
                countMap.put(key, count);
            }
        }

        public void dec(String key) {
            Integer count = countMap.get(key);
            if (count == null) {
                throw new IllegalStateException("invoke error");
            } else {
                if (count == maxKeyCount) {
                    count--;
                    maxKeyCount--;
                }
                if (count == secondMaxKeyCount) {

                }

            }
        }

        public String getMaxKey() {
            return maxKey;
        }

        public String getMinKey() {
            return minKey;
        }
    }
}
