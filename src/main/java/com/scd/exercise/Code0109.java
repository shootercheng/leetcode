package com.scd.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code0109 {
    public boolean isFlipedString(String s1, String s2) {
        char[] s1charArr = s1.toCharArray();
        char[] s2charArr = s2.toCharArray();
        int s1len = s1charArr.length;
        int s2len = s2charArr.length;
        if (s1len != s2len) {
            return false;
        }
        Arrays.sort(s1charArr);
        Arrays.sort(s2charArr);
        for (int i = 0; i < s1len; i++) {
            if (s1charArr[i] != s2charArr[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isFlipedString2(String s1, String s2) {
        char[] s1charArr = s1.toCharArray();
        char[] s2charArr = s2.toCharArray();
        int s1len = s1charArr.length;
        int s2len = s2charArr.length;
        if (s1len != s2len) {
            return false;
        }
        Map<Character, Integer> characterCount = new HashMap<>();
        for (char c : s1charArr) {
            Integer count = characterCount.computeIfAbsent(c, k -> new Integer(0));
            characterCount.put(c, ++count);
        }
        for (char c : s2charArr) {
            Integer count = characterCount.get(c);
            if (count == null) {
                return false;
            }
            if (count == 1) {
                characterCount.remove(c);
            } else {
                characterCount.put(c, --count);
            }
        }
        return characterCount.size() == 0;
    }

}
