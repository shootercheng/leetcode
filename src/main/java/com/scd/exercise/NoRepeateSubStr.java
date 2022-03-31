package com.scd.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class NoRepeateSubStr {

    public static void main(String[] args) {
        String inputStr = "";
        int len = inputStr.length();
        int maxLen = -1;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                String subStr = inputStr.substring(i, j);
                if (!isSame(subStr) && subStr.length() > maxLen) {
                    maxLen = subStr.length();
                }
            }
        }
        System.out.println(maxLen);
    }

    private static boolean isSame(String subStr) {
        char[] charArr = subStr.toCharArray();
        Set<Character> set = new HashSet<>(charArr.length);
        for (char c : charArr) {
            set.add(c);
        }
        if (set.size() != subStr.length()) {
            return true;
        }
        return false;
    }
}
