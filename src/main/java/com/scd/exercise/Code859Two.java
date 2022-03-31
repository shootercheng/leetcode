package com.scd.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code859Two {

    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null) {
            return false;
        }
        char[] acharArr = A.toCharArray();
        char[] bcharArr = B.toCharArray();
        int alen = acharArr.length;
        int blen = bcharArr.length;
        if (alen == 0 || blen == 0) {
            return false;
        }
        if (alen != blen) {
            return false;
        }
        List<Integer> diffIndexList = new ArrayList<>();
        for (int i = 0; i < alen; i++) {
            if (acharArr[i] != bcharArr[i]) {
                diffIndexList.add(i);
                if (diffIndexList.size() == 3) {
                    return false;
                }
            }
        }
        if (diffIndexList.size() == 2) {
            char temp = acharArr[diffIndexList.get(0)];
            acharArr[diffIndexList.get(0)] = acharArr[diffIndexList.get(1)];
            acharArr[diffIndexList.get(1)] = temp;
            if (isSame(acharArr, bcharArr, alen)) {
                return true;
            }
        } else if (diffIndexList.size() == 0) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (Character character : acharArr) {
                Integer count = countMap.computeIfAbsent(character, k -> 0);
                countMap.put(character, ++count);
                if (count == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSame(char[] acharArr, char[] bcharArr, int alen) {
        for (int i = 0; i < alen; i++) {
            if (acharArr[i] != bcharArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abab";
        String b = "abab";
        Code859Two code859 = new Code859Two();
        System.out.println(code859.buddyStrings(a, b));
    }
}
