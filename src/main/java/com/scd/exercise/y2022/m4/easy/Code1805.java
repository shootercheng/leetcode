package com.scd.exercise.y2022.m4.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code1805 {

    public int numDifferentIntegers(String word) {
        Set<String> numSet = new HashSet<>();
        char[] charArr = word.toCharArray();
        int lenc = charArr.length;
        for (int i = 0; i < lenc; i++) {
            if (Character.isLowerCase(charArr[i])) {
                charArr[i] = ' ';
            }
        }
        String str = new String(charArr);
        int count = 0;
        String[] strArr = str.split("\\s+");
        for (String s : strArr) {
            if (s.trim().length() == 0) {
                continue;
            }
            if (s.startsWith("0")) {
                s = removePrefixZero(s);
            }
            if (!numSet.contains(s)) {
                numSet.add(s);
                count++;
            }
        }
        return count;
    }

    private String removePrefixZero(String s) {
        char[] scharArr = s.toCharArray();
        int notZero = -1;
        for (int i = 1; i < scharArr.length; i++) {
            if (scharArr[i] != '0') {
                notZero = i;
                break;
            }
        }
        if (notZero != -1) {
            s = s.substring(notZero);
        } else {
            s = "0";
        }
        return s;
    }

    public static void main(String[] args) {
        String str = "a1b01c001";
        Code1805 code1805 = new Code1805();
        code1805.numDifferentIntegers(str);
        code1805.removePrefixZero("001");
    }
}
