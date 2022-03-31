package com.scd.exercise.y2021.m1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code806 {

    public int[] numberOfLines(int[] widths, String S) {
        Map<Character, Integer> charNumMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char curChar = (char) (i + 'a');
            charNumMap.put(curChar, widths[i]);
        }
        char[] sArr = S.toCharArray();
        int lens = sArr.length;
        int row = 0;
        int index = 0;
        int sum = 0;
        int[] result = new int[2];
        while (index < lens) {
            char curChar = sArr[index];
            int num = charNumMap.get(curChar);
            sum = sum + num;
            if (sum == 100) {
                row++;
                sum = 0;
            } else if (sum > 100) {
                row++;
                sum = 0;
                index--;
            }
            index++;
        }
        if (sum != 0) {
            row++;
            result[1] = sum;
        } else {
            result[1] = 100;
        }
        result[0] = row;
        return result;
    }

    public static void main(String[] args) {
        int[] widths = new int[]{
                4,10,10,10,10,10,10,10,10,10,10,10,
                10,10,10,10,10,10,10,10,10,10,10,10,10,10
        };
        String s = "bbbcccdddaaa";
        Code806 code806 = new Code806();
        System.out.println(code806.numberOfLines(widths, s));
    }
}
