package com.scd.exercise.y2021.m8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code1880 {
    private static Map<Character, Integer> charMap = new HashMap<>();

    static {
        for (int i = 0; i < 26; i++) {
            char curChar = (char) ('a' + i);
            charMap.put(curChar, i);
        }
    }


    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int firstNum = convertStrToNum(firstWord);
        int secondNum = convertStrToNum(secondWord);
        int targetNum = convertStrToNum(targetWord);
        return firstNum + secondNum == targetNum;
    }

    private int convertStrToNum(String word) {
        char[] charArr = word.toCharArray();
        StringBuilder stringBuilder = new StringBuilder("");
        for (char c : charArr) {
            Integer num = charMap.get(c);
            if (num != null) {
                stringBuilder.append(num);
            }
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {
        Code1880 code1880 = new Code1880();
        System.out.println(code1880.convertStrToNum("aaaa"));
    }
}
