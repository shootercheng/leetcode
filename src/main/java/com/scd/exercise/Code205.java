package com.scd.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code205 {

    public boolean isIsomorphic(String s, String t) {
        char[] scharArr = s.toCharArray();
        char[] tcharArr = t.toCharArray();
        int lens = s.length();
        int lent = t.length();
        if (lens != lent) {
            return false;
        }
        Map<Character, Character> charMap = new HashMap<>();
        Set<Character> exists = new HashSet<>();
        for (int i = 0; i < lens; i++) {
            Character mapChar = charMap.get(scharArr[i]);
            if (mapChar == null) {
                // a -> c b -> c
                if (exists.contains(tcharArr[i])) {
                    return false;
                }
                exists.add(tcharArr[i]);
                charMap.put(scharArr[i], tcharArr[i]);
            } else {
                if (mapChar != tcharArr[i]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Code205 code205 = new Code205();
        System.out.println(code205.isIsomorphic("egg", "add"));
    }
}
