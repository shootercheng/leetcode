package com.scd.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code0102 {

    public boolean checkPermutation(String s1, String s2) {
        Map<Character, Integer> charsMap = new HashMap<>(s1.length());
        char[] chars1 = s1.toCharArray();
        for (char c : chars1) {
            Integer num = charsMap.computeIfAbsent(c, k -> new Integer(0));
            charsMap.put(c, ++num);
        }
        char[] chars2 = s2.toCharArray();
        for (char c : chars2) {
            Integer num = charsMap.get(c);
            if (num == null) {
                return false;
            }
            if (num == 1) {
                charsMap.remove(c);
            } else {
                charsMap.put(c, --num);
            }
        }
        return charsMap.size() == 0;
    }

    public boolean checkPermutation2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);
        int lens1 = s1.length();
        for (int i = 0; i < lens1; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        Code0102 code0102 = new Code0102();
        System.out.println(code0102.checkPermutation2(s1, s2));
    }
}
