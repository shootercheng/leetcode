package com.scd.exercise.m12;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code316 {

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int lens = s.length();
        char[] scharArr = s.toCharArray();
        for (int i = 0; i < lens; i++) {
            Integer index = charIndexMap.get(scharArr[i]);
            if (index == null) {
                charIndexMap.put(scharArr[i], i);
            } else {
                for (int j = scharArr[i] - 1; j >= 'a'; j--) {
                    Integer previousIndex = charIndexMap.get((char) j);
                    if (index < previousIndex) {
                        charIndexMap.put(scharArr[i], i);
                    }
                }
            }
        }
        List<Map.Entry<Character, Integer>> list = charIndexMap.entrySet().stream()
                .sorted(Comparator.comparingInt(this::sort))
                .collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            builder.append(entry.getKey());
        }
        return builder.toString();
    }

    private int sort(Map.Entry<Character, Integer> entry) {
        return entry.getValue();
    }

    public static void main(String[] args) {
        String s = "bcabc";
        Code316 code316 = new Code316();
//        System.out.println(code316.removeDuplicateLetters(s));
        System.out.println(code316.removeDuplicateLetters( "cbacdcbc"));
    }
}
