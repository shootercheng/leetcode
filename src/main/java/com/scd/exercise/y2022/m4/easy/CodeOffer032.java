package com.scd.exercise.y2022.m4.easy;

import java.util.Arrays;

/**
 * @author James
 */
public class CodeOffer032 {

    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return false;
        }
        return sortStr(s).equals(sortStr(t));
    }

    private String sortStr(String input) {
        char[] inputArr = input.toCharArray();
        Arrays.sort(inputArr);
        return new String(inputArr);
    }
}
