package com.scd.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code884 {

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> acountMap = countWords(A);
        Map<String, Integer> bcountMap = countWords(B);
        List<String> resultList = new ArrayList<>();
        addResult(acountMap, bcountMap, resultList);
        addResult(bcountMap, acountMap, resultList);
        int size = resultList.size();
        String[] resArr = new String[size];
        for (int i = 0; i < size; i++) {
            resArr[i] = resultList.get(i);
        }
        return resArr;
    }

    private Map<String, Integer> countWords(String a) {
        String[] awords = a.split("\\s+");
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : awords) {
            Integer count = countMap.computeIfAbsent(s, k -> 0);
            countMap.put(s, ++count);
        }
        return countMap;
    }

    private void addResult(Map<String, Integer> acountMap, Map<String, Integer> bcountMap, List<String> resultList) {
        Set<Map.Entry<String, Integer>> aentrySet = acountMap.entrySet();
        for (Map.Entry<String, Integer> entry : aentrySet) {
            String word = entry.getKey();
            if (entry.getValue() == 1 && !bcountMap.containsKey(word)) {
                resultList.add(word);
            }
        }
    }
}
