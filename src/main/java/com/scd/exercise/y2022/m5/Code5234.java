package com.scd.exercise.y2022.m5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 5234. 移除字母异位词后的结果数组
 * @author James
 */
public class Code5234 {

    public List<String> removeAnagrams(String[] words) {
        Map<Integer, char[]> wordMap = new HashMap<>();
        int lenw = words.length;
        for (int i = 0; i < lenw; i++) {
            char[] charArr = words[i].toCharArray();
            Arrays.sort(charArr);
            wordMap.put(i, charArr);
        }
        while (true) {
            boolean isRemove = false;
            int startIndex = 0;
            while (startIndex < lenw - 1) {
                char[] charArr1 = wordMap.get(startIndex);
                int index2 = findNextCharArr(startIndex, wordMap, lenw);
                if (index2 != -1) {
                    if (charArr1 != null) {
                        char[] charArr2 = wordMap.get(index2);
                        if (isSame(charArr1, charArr2)) {
                            wordMap.remove(index2);
                            isRemove = true;
                        }
                    }
                }
                startIndex++;
            }
            if (!isRemove) {
                break;
            }
        }
        List<String> result = new ArrayList<>();
        List<Integer> keySet = wordMap.keySet().stream().sorted().collect(Collectors.toList());
        for (int index : keySet) {
            result.add(words[index]);
        }
        return result;
    }

    private int findNextCharArr(int startIndex, Map<Integer,char[]> wordMap, int lenw) {
        for (int i = startIndex + 1; i < lenw; i++) {
            char[] charArr = wordMap.get(i);
            if (charArr != null) {
                return i;
            }
        }
        return -1;
    }

    private boolean isSame(char[] charArr1, char[] charArr2) {
        int len1 = charArr1.length;
        int len2 = charArr2.length;
        if (len1 != len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            if (charArr1[i] != charArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
