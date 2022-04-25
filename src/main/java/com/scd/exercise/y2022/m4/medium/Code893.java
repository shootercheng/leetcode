package com.scd.exercise.y2022.m4.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 893. 特殊等价字符串组
 * @author James
 */
public class Code893 {

    public int numSpecialEquivGroups(String[] A) {
        Map<String, List<String>> countMap = new HashMap<>();
        for (String str : A) {
            char[] chArr = str.toCharArray();
            int lenc = chArr.length;
            List<Character> list1 = new ArrayList<>();
            List<Character> list2 = new ArrayList<>();
            for (int i = 0; i < lenc; i++) {
                if (i % 2 == 0) {
                    list2.add(chArr[i]);
                } else {
                    list1.add(chArr[i]);
                }
            }
            String key = getKey(list1, list2);
            List<String> strList = countMap.computeIfAbsent(key, k -> new ArrayList<>());
            strList.add(str);
        }
        return countMap.size();
    }

    private String getKey(List<Character> list1, List<Character> list2) {
        list1 = list1.stream().sorted().collect(Collectors.toList());
        list2 = list2.stream().sorted().collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        list1.forEach(stringBuilder::append);
        stringBuilder.append("_");
        list2.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Code893 code893 = new Code893();
        code893.numSpecialEquivGroups(new String[]{"abcd","cdab","cbad","xyzz","zzxy","zzyx"});
    }
}
