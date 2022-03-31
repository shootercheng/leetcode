package com.scd.exercise.y2021.m7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code13 {
    private static Map<Character, Integer> ELEMENT_MAP = new HashMap<>();

    static {
        ELEMENT_MAP.put('I', 1);
        ELEMENT_MAP.put('V', 5);
        ELEMENT_MAP.put('X', 10);
        ELEMENT_MAP.put('L', 50);
        ELEMENT_MAP.put('C', 100);
        ELEMENT_MAP.put('D', 500);
        ELEMENT_MAP.put('M', 1000);
    }

    public int romanToInt(String s) {
        char[] scharArr = s.toCharArray();
        int lens = scharArr.length;
        int sum = 0;
        for (int i = 0; i < lens; i++) {
            char curChar = scharArr[i];
            boolean isSub = false;
            if (curChar == 'V' || curChar == 'X') {
                if (i != 0) {
                    char previous = scharArr[i-1];
                    if (previous == 'I') {
                        sum = sum - 1 + ELEMENT_MAP.get(curChar) - 1;
                        isSub = true;
                    }
                }
            } else if (curChar == 'L' || curChar == 'C') {
                if (i != 0) {
                    char previous = scharArr[i - 1];
                    if (previous == 'X') {
                        sum = sum - 10 + ELEMENT_MAP.get(curChar) - 10;
                        isSub = true;
                    }
                }
            } else if (curChar == 'D' || curChar == 'M') {
                if (i != 0) {
                    char previous = scharArr[i - 1];
                    if (previous == 'C') {
                        sum = sum - 100 + ELEMENT_MAP.get(curChar) - 100;
                        isSub = true;
                    }
                }
            }
            if (!isSub) {
                sum = sum + ELEMENT_MAP.get(curChar);
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        Code13 code13 = new Code13();
//        System.out.println(code13.romanToInt("IV"));
        System.out.println(code13.romanToInt("XXVII"));
        System.out.println(code13.romanToInt("LVIII"));
        System.out.println(code13.romanToInt("MMM"));
    }
}
