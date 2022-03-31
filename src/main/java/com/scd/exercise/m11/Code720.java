package com.scd.exercise.m11;

import java.util.ArrayList;
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
        List<String> wordList = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordList.add(word);
            wordSet.add(word);
        }
        wordList = wordList.stream().sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());
        return "";
    }
}
