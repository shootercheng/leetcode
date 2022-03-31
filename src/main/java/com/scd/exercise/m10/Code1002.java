package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code1002 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> wordMap = new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String newStr = new String(charArr);
            List<String> wordList = wordMap.computeIfAbsent(newStr, k -> new ArrayList<>());
            wordList.add(str);
        }
        return new ArrayList<>(wordMap.values());
    }
}
