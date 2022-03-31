package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author James
 */
public class Code917 {

    public String reverseOnlyLetters(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] scharArr = S.toCharArray();
        int lens = S.length();
        Map<Integer, Character> map = new TreeMap<>();
        for (int i = 0; i < lens; i++) {
            if (Character.isLetter(scharArr[i])) {
                stringBuilder.append(scharArr[i]);
            } else {
                map.put(i, scharArr[i]);
            }
        }
        stringBuilder = stringBuilder.reverse();
        Set<Map.Entry<Integer, Character>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Character> entry : entrySet) {
            stringBuilder.insert(entry.getKey().intValue(), entry.getValue().charValue());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Code917 code917 = new Code917();
        System.out.println(code917.reverseOnlyLetters("ab-cd"));
        System.out.println(code917.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(code917.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
