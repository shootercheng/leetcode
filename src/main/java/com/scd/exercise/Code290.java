package com.scd.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code290 {

    public boolean wordPattern(String pattern, String str) {
        char[] charArr = pattern.toCharArray();
        String[] strArr = str.split("\\s+");
        int charLen = charArr.length;
        int strLen = strArr.length;
        if (charLen != strLen) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> strMapped = new HashSet<>();
        for (int i = 0; i < charLen; i++) {
            char curChar = charArr[i];
            String mapStr = map.get(curChar);
            if (mapStr == null) {
                if (strMapped.contains(strArr[i])) {
                    return false;
                }
                strMapped.add(strArr[i]);
                map.put(curChar, strArr[i]);
            } else {
                if (!mapStr.equals(strArr[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Code290 code290 = new Code290();
//        System.out.println(code290.wordPattern("abba", "dog cat cat dog"));
//        System.out.println(code290.wordPattern("abba", "dog cat cat fish"));
        System.out.println(code290.wordPattern("abba", "dog dog dog dog"));
    }
}
