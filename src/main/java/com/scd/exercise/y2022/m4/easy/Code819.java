package com.scd.exercise.y2022.m4.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>();
        for (String ban : banned) {
            banSet.add(ban);
        }
        paragraph = paragraph.replaceAll("[!?',;.]", " ");
        String[] strArr = paragraph.split("\\s+");
        Map<String, Integer> countMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String maxStrKey = "";
        for (String str : strArr) {
            str = str.trim();
            if (str.length() == 0) {
                continue;
            }
            str = str.toLowerCase();
            if (banSet.contains(str)) {
                continue;
            }
            Integer count = countMap.computeIfAbsent(str, k -> 0);
            countMap.put(str, ++count);
            if (count > max) {
                max = count;
                maxStrKey = str;
            }
        }
        return maxStrKey;
    }

    public static void main(String[] args) {
//        "Bob hit a ball, the hit BALL flew far after it was hit."
//                ["hit"]
//        "a, a, a, a, b,b,b,c, c"
//                ["a"]
        Code819 code819 = new Code819();
        code819.mostCommonWord("a, a, a, a, b,b,b,c, c",
                new String[]{"a"});

    }
}
