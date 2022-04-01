package com.scd.exercise.y2022.m4.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 1763. 最长的美好子字符串
 * @author James
 */
public class Code1763 {
    public String longestNiceSubstring(String s) {
        int lens = s.length();
        String maxStr = "";
        int maxLen = 0;
        for (int i = 0; i < lens; i++) {
            for (int j = i+1; j <= lens; j++) {
                String subStr = s.substring(i, j);
                if (isNiceStr(subStr)) {
                    int lenSub = subStr.length();
                    if (lenSub > maxLen) {
                        maxLen = lenSub;
                        maxStr = subStr;
                    }
                }
            }
        }
        return maxStr;
    }

    private boolean isNiceStr(String str) {
        Set<Character> charSet = new HashSet<>();
        char[] strCharArr = str.toCharArray();
        for (char input : strCharArr) {
            charSet.add(input);
        }
        for (char input : strCharArr) {
            if (Character.isLowerCase(input)) {
                char upper = (char) (input - 32);
                if (!charSet.contains(upper)) {
                    return false;
                }
            } else {
                char lower = (char) (input + 32);
                if (!charSet.contains(lower)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Code1763 code1763 = new Code1763();
        code1763.longestNiceSubstring("YazaAay");
    }
}
