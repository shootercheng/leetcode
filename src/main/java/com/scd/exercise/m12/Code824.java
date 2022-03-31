package com.scd.exercise.m12;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class Code824 {

    private static Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u',
                                                        'A','E','I','O','U'));

    public String toGoatLatin(String S) {
        int lens = S.length();
        char[] sArr = S.toCharArray();
        int startIndex = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        StringBuilder word = new StringBuilder();
        int wordStart = 0;
        boolean isOwel = false;
        while (startIndex < lens) {
            char curChar = sArr[startIndex];
            System.out.println(curChar);
            if (wordStart == 0) {
                if (set.contains(curChar)) {
                    isOwel = true;
                } else {
                    isOwel = false;
                }
            }
            if (curChar == ' ') {
                appendWord(stringBuilder, count, word, isOwel);
                wordStart = 0;
                count++;
                word.setLength(0);
            } else {
                word.append(curChar);
                wordStart++;
            }
            startIndex++;
        }
        appendWord(stringBuilder, count, word, isOwel);
        return stringBuilder.toString().trim();
    }

    private void appendWord(StringBuilder stringBuilder, int count, StringBuilder word, boolean isOwel) {
        if (!isOwel) {
            String start = word.substring(0, 1);
            String subWord = word.substring(1);
            word = new StringBuilder(subWord);
            word.append(start).append("ma");
        } else {
            word.append("ma");
        }
        appendA(word, count);
        stringBuilder.append(word).append(" ");
    }

    public void appendA(StringBuilder word, int num) {
        for (int i = 0; i < num; i++) {
            word.append("a");
        }
    }

    public static void main(String[] args) {
        Code824 code824 = new Code824();
        System.out.println(code824.toGoatLatin("I speak Goat Latin"));
    }
}
