package com.scd.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("[!?',;\\. ]");
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            if (word == null) {
                continue;
            }
            if (word.trim().length() == 0) {
                continue;
            }
            word = word.toLowerCase();
            Integer count = countMap.computeIfAbsent(word, k -> 0);
            countMap.put(word, ++count);
        }
        List<String> keySet = new ArrayList<>(countMap.keySet());
        for (String key : keySet) {
            if (isBanned(key, banned)) {
                countMap.remove(key);
            }
        }
        Set<Map.Entry<String, Integer>> entrySet = countMap.entrySet();
        int max = Integer.MIN_VALUE;
        String maxWord = "";
        for (Map.Entry<String, Integer> entry : entrySet) {
            int count = entry.getValue();
            if (count > max) {
                max = count;
                maxWord = entry.getKey();
            }
        }
        return maxWord;
    }

    private boolean isBanned(String word, String[] banned) {
        for (String ban : banned) {
            if (word.equals(ban)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        Code819 code819 = new Code819();
        String res = code819.mostCommonWord(paragraph, banned);
        System.out.println(res);
    }
}
