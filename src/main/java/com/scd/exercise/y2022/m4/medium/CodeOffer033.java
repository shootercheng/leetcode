package com.scd.exercise.y2022.m4.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer II 033. 变位词组
 * @author James
 */
public class CodeOffer033 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        int lens = strs.length;
        for (int i = 0; i < lens; i++) {
            char[] chArr = strs[i].toCharArray();
            Arrays.sort(chArr);
            String key = new String(chArr);
            List<String> strList = groupMap.computeIfAbsent(key, k -> new ArrayList<>());
            strList.add(strs[i]);
        }
        return new ArrayList<>(groupMap.values());
    }
}
