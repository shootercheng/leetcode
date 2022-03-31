package com.scd.exercise.y2021.m1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code677 {

    class MapSum {
        private Map<String, Integer> keyMap;

        /** Initialize your data structure here. */
        public MapSum() {
            keyMap = new HashMap<>();
        }

        public void insert(String key, int val) {
            keyMap.put(key, val);
        }

        public int sum(String prefix) {
           Set<String> keySet = keyMap.keySet();
           int sum = 0;
           for (String key : keySet) {
               if (key.startsWith(prefix)) {
                   sum = sum + keyMap.get(key);
               }
           }
           return sum;
        }
    }
}
