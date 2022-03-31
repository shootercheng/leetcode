package com.scd.exercise.y2021.m7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code5809 {

    public int countPalindromicSubsequence(String s) {
        Map<Character, List<Integer>> charIndexMap = new HashMap<>();
        char[] charArr = s.toCharArray();
        int lenc = charArr.length;
        for (int i = 0; i < lenc; i++) {
            List<Integer> indexList = charIndexMap.computeIfAbsent(charArr[i], k -> new ArrayList<>());
            indexList.add(i);
        }
        Set<String> charSet = new HashSet<>();
        charIndexMap.forEach(((character, list) -> {
            // 至少2个以上字符相同
            if (list.size() >= 2) {
                int firstIndex = list.get(0);
                int lastIndex = list.get(list.size() - 1);
                // 至少3个字符
                if (lastIndex - firstIndex > 1) {
                    for (int i = firstIndex + 1; i < lastIndex; i++) {
                        String curStr = "" + charArr[firstIndex] + charArr[i] + charArr[lastIndex];
                        charSet.add(curStr);
                    }
                }
            }
        }));
        return charSet.size();
    }

    public static void main(String[] args) {
        Code5809 code5809 = new Code5809();
        code5809.countPalindromicSubsequence("aabca");
    }

}
