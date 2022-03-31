package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code791 {

    public String customSortString(String S, String T) {
        char[] sArr = S.toCharArray();
        int lens = sArr.length;
        Map<Integer, Character> intCharMap = new HashMap<>();
        Map<Character, Integer> charIntMap = new HashMap<>();
        for (int i = 0; i < lens; i++) {
            intCharMap.put(i, sArr[i]);
            charIntMap.put(sArr[i], i);
        }
        char[] tArr = T.toCharArray();
        int lent = tArr.length;
        StringBuilder endStr = new StringBuilder();
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < lent; i++) {
            Integer cInt = charIntMap.get(tArr[i]);
            if (cInt == null) {
                endStr.append(tArr[i]);
            } else {
                intList.add(cInt);
            }
        }
        List<Integer> sortList = intList.stream().sorted().collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        sortList.forEach(cInt -> {
            result.append(intCharMap.get(cInt));
        });
        return result.append(endStr).toString();
    }
}
