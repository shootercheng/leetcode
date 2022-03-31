package com.scd.book.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 同构字符串
 * @author James
 */
public class ExSameStr {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMap = new HashMap<>(16);
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int i = 0;
        int j = 0;
        int lens = s.length();
        int lent = t.length();
        Set<Character> mapSet = new HashSet<>();
        while (i < lens && j < lent) {
            Character mapCharI = charMap.get(sArr[i]);
            if (mapCharI == null) {
                if (!mapSet.contains(tArr[j])) {
                    mapSet.add(tArr[j]);
                    charMap.put(sArr[i], tArr[j]);
                } else {
                    return false;
                }
            } else {
                if (mapCharI != tArr[j]) {
                    return false;
                }
            }
            i++;
            j++;
        }
        return true;
    }
}
