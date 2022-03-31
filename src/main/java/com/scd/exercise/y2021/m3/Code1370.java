package com.scd.exercise.y2021.m3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code1370 {

    public String sortString(String s) {
        char[] sArr = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : sArr) {
            Integer count = charMap.computeIfAbsent(c, k -> 0);
            charMap.put(c, ++count);
            charSet.add(c);
        }
        List<Character> charList = new ArrayList<>(charSet);
        charList = charList.stream().sorted().collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        List<Character> reverseList = reverseList(charList);
        while (charMap.size() != 0) {
            appendStr(charMap, charList, result);
            if (charMap.size() == 0) {
                break;
            }
            appendStr(charMap, reverseList, result);
        }
        return result.toString();
    }

    private void appendStr(Map<Character, Integer> charMap, List<Character> charList, StringBuilder result) {
        for (Character c : charList) {
            Integer count = charMap.get(c);
            if (count == null) {
                continue;
            }
            count--;
            if (count == 0) {
                charMap.remove(c);
            } else {
                charMap.put(c, count);
            }
            result.append(c);
        }
    }

    private List<Character> reverseList(List<Character> charList) {
        int lenc = charList.size();
        List<Character> list = new ArrayList<>();
        for (int i = lenc - 1; i >= 0; i--) {
            Character curChar = charList.get(i);
            list.add(curChar);
        }
        return list;
    }

    public static void main(String[] args) {
        Code1370 code1370 = new Code1370();
        System.out.println(code1370.sortString("aaaabbbbcccc"));
    }
}
