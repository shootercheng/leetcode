package com.scd.exercise.y2022.m6.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code2283 {

    public boolean digitCount(String num) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int lenn = num.length();
        for (int i = 0; i < lenn; i++) {
            char curChar = num.charAt(i);
            int numc = (int) (curChar - 48);
            Integer count = countMap.computeIfAbsent(numc, k -> 0);
            countMap.put(numc, ++count);
        }
        for (int i = 0; i < lenn; i++) {
            char curChar = num.charAt(i);
            int numc = (int) (curChar - 48);
            Integer val = countMap.get(i);
            if (val == null) {
                val = 0;
            }
            if (numc != val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] chars = {'1', '2', '3', '4', '5'};
        for (char c : chars) {
            int numc = (int) (c - 48);
            System.out.println(numc);
        }
    }
}