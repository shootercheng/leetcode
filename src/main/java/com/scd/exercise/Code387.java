package com.scd.exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code387 {

    public int firstUniqChar(String s) {
        char[] scharArr = s.toCharArray();
        Map<Character, Integer> integerMap = new LinkedHashMap<>();
        for (char c : scharArr) {
            Integer count = integerMap.computeIfAbsent(c, k -> new Integer(0));
            integerMap.put(c, ++count);
        }
        Set<Map.Entry<Character, Integer>> entrySet = integerMap.entrySet();
        Character find = null;
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() == 1) {
                find = entry.getKey();
                break;
            }
        }
        if (find != null) {
            int len = scharArr.length;
            for (int i = 0; i < len; i++) {
                if (scharArr[i] == find) {
                    return i;
                }
            }
        }
        return -1;
    }
}
