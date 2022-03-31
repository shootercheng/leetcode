package com.scd.exercise.y2022.m3;

import java.util.Stack;

/**
 * @author James
 */
public class Code1190 {

    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                StringBuilder temp = new StringBuilder();
                while (stack.peek() != '(') {
                    temp.append(stack.pop());
                }
                stack.pop();
                int lent = temp.length();
                for (int i = 0; i < lent; i++) {
                    stack.push(temp.charAt(i));
                }
            }
        }
        return "";
    }
}
