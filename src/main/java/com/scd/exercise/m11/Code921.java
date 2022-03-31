package com.scd.exercise.m11;

import java.util.Stack;

/**
 * @author James
 */
public class Code921 {

    public int minAddToMakeValid(String S) {
        char[] scharArr = S.toCharArray();
        int left = 0;
        int count = 0;
        for (char c : scharArr) {
            if (c == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    count++;
                }
            }
        }
        if (left > 0) {
            count = left + count;
        }
        return count;
    }
}
