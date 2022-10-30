package com.scd.exercise.y2022.m5;

import java.util.Stack;

/**
 * @author James
 */
public class Code1021 {

    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int lens = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < lens; i++) {
            char curChar = s.charAt(i);
            temp.append(curChar);
            if (curChar == '(') {
                stack.push(curChar);
            } else if (curChar == ')') {
                stack.pop();
            }
            if (stack.isEmpty()) {
                String tempStr = temp.toString();
                tempStr = tempStr.substring(1, tempStr.length() - 1);
                result.append(tempStr);
                temp.setLength(0);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String temp = "(()())(())";
        Code1021 code1021 = new Code1021();
        code1021.removeOuterParentheses(temp);
    }
}
