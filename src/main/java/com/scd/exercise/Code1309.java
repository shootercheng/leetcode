package com.scd.exercise;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code1309 {
    private static Map<String, Character> STR_MAP = new HashMap<>();

    static {
        for (int i = 0; i < 9; i++) {
            char tmpChar = (char) ((int) 'a' + i);
            STR_MAP.put(String.valueOf(i+1), tmpChar);
        }
        for (int i = 9; i < 26; i++) {
            char tmpChar = (char) ((int) 'a' + i);
            String str = i + 1 + "#";
            STR_MAP.put(str, tmpChar);
        }
    }

    public String freqAlphabets(String s) {
        char[] scharArr = s.toCharArray();
        int len = scharArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            char curChar = scharArr[i];
            if (curChar == '#') {
                stringBuilder.setLength(0);
                stringBuilder.append(scharArr[--i]);
                stringBuilder.insert(0, scharArr[--i]);
                stringBuilder.append('#');
                list.add(stringBuilder.toString());
            } else {
                stringBuilder.setLength(0);
                stringBuilder.append(curChar);
                list.add(stringBuilder.toString());
            }
        }
        int size = list.size();
        StringBuilder result = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            Character curChar = STR_MAP.get(list.get(i));
            result.append(curChar);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Code1309 code1309 = new Code1309();
        String result = code1309.freqAlphabets("12325#10#");
        System.out.println(result);
    }
}