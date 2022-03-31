package com.scd.exercise.y2021.m1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code720 {

    public String longestWord(String[] words) {
        int lenw = words.length;
        if (lenw < 1) {
            return "";
        }
        List<String> wordList = Arrays.stream(words).sorted(Comparator.comparingInt(this::sort))
                .collect(Collectors.toList());
        Set<String> strSet = new HashSet<>();
        for (String word : words) {
            strSet.add(word);
        }
        int maxLen = 0;
        List<String> result = new ArrayList<>();
        for (int i=lenw - 1; i >= 0; i--) {
            String curStr = wordList.get(i);
            if (result.size() == 1 && curStr.length() < maxLen) {
                break;
            }
            int lenc = curStr.length() - 1;
            boolean hasSub = true;
            for (int j = lenc; j >= 1; j--) {
                String subCurStr = curStr.substring(0, j);
                if (!strSet.contains(subCurStr)) {
                    hasSub = false;
                    break;
                }
            }
            if (maxLen == 0 && hasSub) {
                maxLen = curStr.length();
                result.add(curStr);
            } else {
                if (curStr.length() == maxLen && hasSub) {
                    result.add(curStr);
                }
            }
        }
        if (result.size() > 0) {
            result = result.stream().sorted().collect(Collectors.toList());
            return result.get(0);
        }
        return "";
    }

    private int sort(String t) {
        return t.length();
    }

    public static void main(String[] args) {
        String[] inputWord = {"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu",
                "lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};
        Code720 code720 = new Code720();
        System.out.println(code720.longestWord(inputWord));
    }
}
