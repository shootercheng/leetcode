package com.scd.exercise.m10;

import java.util.Stack;

/**
 * @author James
 */
public class Code1614 {

    public int maxDepth(String s) {
        char[] sArr = s.toCharArray();
        int max = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : sArr) {
            if (c == '(') {
                stack.push(c);
                if (stack.size() > max) {
                    max = stack.size();
                }
            } else if (c == ')') {
                stack.pop();
            }
        }
        return max;
    }
}
