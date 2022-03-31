package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code345 {

    private static List<Character> VOWEL_LIST = Arrays.asList('a','e','i','o','u',
            'A','E','I','O','U');

    public String reverseVowels(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        List<Integer> vowelIndexList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (isVOWEL(chars[i])) {
                vowelIndexList.add(i);
            }
        }
        int size = vowelIndexList.size();
        int center = size / 2;
        int i = 0;
        int j = size - 1;
        while (i < center) {
            int iVal = vowelIndexList.get(i);
            int jVal = vowelIndexList.get(j);
            char temp = chars[iVal];
            chars[iVal] = chars[jVal];
            chars[jVal] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public boolean isVOWEL(char inputChar) {
        return VOWEL_LIST.contains(inputChar);
    }

    public static void main(String[] args) {
        String str = "helloo";
        Code345 code345 = new Code345();
        System.out.println(code345.reverseVowels(str));
    }
}
