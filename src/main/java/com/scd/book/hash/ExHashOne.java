package com.scd.book.hash;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class ExHashOne {
    public int firstUniqChar(String s) {
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            Integer num = countMap.computeIfAbsent(c, k -> 0);
            countMap.put(c, ++num);
        }
        Set<Map.Entry<Character, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        boolean[] boolNum = new boolean[2];
        System.out.println(boolNum[0]);
    }
}
