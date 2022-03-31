package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            Integer count = countMap.computeIfAbsent(word, a -> 0);
            countMap.put(word, ++count);
        }
        Set<Map.Entry<String, Integer>> entrySet = countMap.entrySet();
        Map<Integer, List<String>> numWordsMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : entrySet) {
            List<String> list = numWordsMap.computeIfAbsent(entry.getValue(), a -> new ArrayList<>());
            list.add(entry.getKey());
        }
        List<Integer> countList = numWordsMap.keySet().stream()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<String> resultList = new ArrayList<>();
        int i = 0;
        while (k > 0) {
            List<String> listWords = numWordsMap.get(countList.get(i));
            listWords = listWords.stream().sorted().collect(Collectors.toList());
            if (listWords.size() > k) {
                listWords = listWords.subList(0, k);
                resultList.addAll(listWords);
                return resultList;
            } else {
                resultList.addAll(listWords);
                k = k - listWords.size();
            }
            i++;
        }
        return resultList;
    }

    public static void main(String[] args) {
        Code692 code692 = new Code692();
        String[] input = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(code692.topKFrequent(input, 1));
    }
}
