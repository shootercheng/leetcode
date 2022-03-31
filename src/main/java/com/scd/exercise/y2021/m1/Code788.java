package com.scd.exercise.y2021.m1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code788 {

    private static Map<Character, Character> charMap = new HashMap<>();

    static {
        charMap.put('0', '0');
        charMap.put('1', '1');
        charMap.put('8', '8');
        charMap.put('2', '5');
        charMap.put('6', '9');
        charMap.put('5', '2');
        charMap.put('9', '6');
    }

    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            String strN = String.valueOf(i);
            char[] strArrN = strN.toCharArray();
            boolean isGood = true;
            StringBuilder ratioStr = new StringBuilder("");
            for (char c : strArrN) {
                if (!charMap.containsKey(c)) {
                    isGood = false;
                    break;
                }
                ratioStr.append(charMap.get(c));
            }
            if (isGood && !strN.equals(ratioStr.toString())) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Code788 code788 = new Code788();
        System.out.println(code788.rotatedDigits(10));
    }
}
