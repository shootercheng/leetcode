package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code830 {

    public List<List<Integer>> largeGroupPositions(String s) {
        char[] sArr = s.toCharArray();
        Map<Character, List<Integer>> charIndexMap = new LinkedHashMap<>();
        int lena = sArr.length;
        for (int i = 0; i < lena; i++) {
            List<Integer> indexList = charIndexMap.computeIfAbsent(sArr[i], k -> new ArrayList<>());
            indexList.add(i);
        }
        Set<Map.Entry<Character, List<Integer>>> entrySet = charIndexMap.entrySet();
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Character, List<Integer>> entry : entrySet) {
            List<Integer> arrayIndexList = entry.getValue();
            List<List<Integer>> oneRes = createLargeGroup(arrayIndexList);
            if (oneRes.size() != 0) {
                result.addAll(oneRes);
            }
        }
        result = result.stream().sorted(Comparator.comparing(list -> list.get(0))).collect(Collectors.toList());
        return result;
    }

    private List<List<Integer>> createLargeGroup(List<Integer> arrayIndexList) {
        List<List<Integer>> result = new ArrayList<>();
        int size = arrayIndexList.size();
        if (size < 3) {
            return result;
        }
        // 1,2,3,5,7,9,10,11,12
        int startIndex = 0;
        int endIndex = 1;
        while (endIndex < size) {
            int val = arrayIndexList.get(endIndex) - arrayIndexList.get(endIndex - 1);
            if (val == 1) {
                endIndex = endIndex + 1;
            } else {
                if (endIndex - startIndex >= 3) {
                    addResult(arrayIndexList, result, startIndex, endIndex);
                }
                startIndex = endIndex;
                endIndex = startIndex + 1;
            }
        }
        if (endIndex - startIndex >= 3) {
            addResult(arrayIndexList, result, startIndex, endIndex);
        }
        return result;
    }

    private void addResult(List<Integer> arrayIndexList, List<List<Integer>> result, int startIndex, int endIndex) {
        List<Integer> one = new ArrayList<>();
        one.add(arrayIndexList.get(startIndex));
        one.add(arrayIndexList.get(endIndex - 1));
        result.add(one);
    }

    public static void main(String[] args) {
        String str = "abcdddeeeeaabbbcd";
        Code830 code830 = new Code830();
//        System.out.println(code830.largeGroupPositions(str));
//        System.out.println(code830.largeGroupPositions("rrgrrrrraa"));
//        System.out.println(code830.largeGroupPositions("nnnhaaannnm"));
        System.out.println(code830.createLargeGroup(Arrays.asList(1,2,3,5,7,9,10,11,12)));
        System.out.println(code830.createLargeGroup(Arrays.asList(1,2,3,4,5)));
        System.out.println(code830.createLargeGroup(Arrays.asList(1,2,4,8,9,10,11,15,16)));
        System.out.println(code830.createLargeGroup(Arrays.asList(1,2,3,5,8,9,10,11,15,16,17)));
    }
}
