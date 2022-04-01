package com.scd.exercise.y2022.m3;

import java.util.HashMap;
import java.util.Map;

/**
 * 1974. 使用特殊打字机键入单词的最少时间
 * @author James
 */
public class Code1974 {

    private static final Map<Character, Integer> charMap = new HashMap<>();

    static {
        for (int i = 0; i < 26; i++) {
            char curChar = (char) ('a' + i);
            charMap.put(curChar, i+1);
        }
    }

    public int minTimeToType(String word) {
        char[] wcharArr = word.toCharArray();
        int pre = charMap.get('a');
        int result = word.length();
        for (char curchar : wcharArr) {
            int cur = charMap.get(curchar);
            int order = calOrder(pre, cur);
            int disOrder = calDisOrder(pre, cur);
            result = result + Math.min(order, disOrder);
            pre = cur;
        }
        return result;
    }

    private int calDisOrder(int pre, int cur) {
        if (cur <= pre) {
            return pre - cur;
        }
        return pre + 26 - cur;
    }

    private int calOrder(int pre, int cur) {
        if (cur >= pre) {
            return cur - pre;
        }
        return 26 - pre + cur;
    }

    public static void main(String[] args) {
        Code1974 code1974 = new Code1974();
        code1974.minTimeToType("abc");
    }
}
