package com.scd.contest.week251;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code5823 {
    private static Map<Character, String> charMap = new HashMap<>();

    static {
        for (int i = 0; i < 26; i++) {
            char temp = (char) ('a' + i);
            charMap.put(temp, String.valueOf(i+1));
        }
    }

    public int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            stringBuilder.append(charMap.get(c));
        }
        int i = 0;
        int sum = 0;
        while (i < k) {
            sum = 0;
            char[] chars = stringBuilder.toString().toCharArray();
            for (char num : chars) {
                sum = sum + Integer.parseInt(num + "");
            }
            stringBuilder.setLength(0);
            stringBuilder.append(sum);
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Code5823 code5823 = new Code5823();
        System.out.println(code5823.getLucky("zbax", 2));
    }
}
