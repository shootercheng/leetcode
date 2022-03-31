package com.scd.exercise;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr) {
            Integer count = countMap.computeIfAbsent(i, k -> 0);
            countMap.put(i, ++count);
        }
        Collection<Integer> values = countMap.values();
        Iterator<Integer> iterator = values.iterator();
        Set<Integer> set = new HashSet<>();
        while (iterator.hasNext()) {
            Integer val = iterator.next();
            set.add(val);
        }
        if (set.size() == countMap.size()) {
            return true;
        }
        return false;
    }
}
