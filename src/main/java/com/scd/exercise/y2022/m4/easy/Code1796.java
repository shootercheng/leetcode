package com.scd.exercise.y2022.m4.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 1796. 字符串中第二大的数字
 * @author James
 */
public class Code1796 {

    public int secondHighest(String s) {
        char[] sArr = s.toCharArray();
        int fisrt = -1;
        int second = -1;
        Set<Character> numSet = new HashSet<>();
        for (char c : sArr) {
            if (Character.isDigit(c)) {
                if (numSet.contains(c)) {
                    continue;
                }
                numSet.add(c);
                int curNum = c - 48;
                if (curNum > second) {
                    second = curNum;
                }
                if (curNum > fisrt) {
                    second = fisrt;
                    fisrt = curNum;
                }
            }
        }
        if (fisrt == second) {
            return -1;
        }
        return second;
    }

    public static void main(String[] args) {
        Code1796 code1796 = new Code1796();
//        System.out.println(code1796.secondHighest("1234567"));
//        System.out.println(code1796.secondHighest("654321"));
        System.out.println(code1796.secondHighest("22333"));
    }
}
