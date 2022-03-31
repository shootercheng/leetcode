package com.scd.exercise.y2021.m1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] orderCharArr = order.toCharArray();
        int leno = order.length();
        for (int i = 0; i < leno; i++) {
            charMap.put(orderCharArr[i], i);
        }
        int lenw = words.length;
        String[] tempWords = new String[lenw];
        System.arraycopy(words, 0, tempWords, 0, lenw);
        Arrays.sort(tempWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                char[] o1Arr = o1.toCharArray();
                char[] o2Arr = o2.toCharArray();
                if (len1 > len2) {
                    return compareChar(o1Arr, o2Arr, charMap);
                } else {
                    int result = compareChar(o2Arr, o1Arr, charMap);
                    if (result != 0) {
                        return -result;
                    }
                    return 0;
                }
            }
        });
        for (int i = 0; i < lenw; i++) {
            if (!words[i].equals(tempWords[i])) {
                return false;
            }
        }
        return true;
    }

    public int compareChar(char[] o1Arr, char[] o2Arr, Map<Character, Integer> charMap) {
        int leno1 = o1Arr.length;
        int leno2 = o2Arr.length;
        for (int i = 0; i < leno2; i++) {
            int o1Int = charMap.get(o1Arr[i]);
            int o2Int = charMap.get(o2Arr[i]);
            if (o1Int > o2Int) {
                return 1;
            } else if (o1Int < o2Int) {
                return -1;
            }
        }
        if (leno1 == leno2) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Code953 code953 = new Code953();
//        String[] words = {"apple","app"};
//        String order = "abcdefghijklmnopqrstuvwxyz";
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(code953.isAlienSorted(words, order));
    }
}
