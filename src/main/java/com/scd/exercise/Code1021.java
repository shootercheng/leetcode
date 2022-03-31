package com.scd.exercise;

import java.util.Stack;

/**
 * @author James
 */
public class Code1021 {

    public String removeOuterParentheses(String S) {
        char[] charArr = S.toCharArray();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArr) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            }
            stringBuilder.append(c);
            if (stack.isEmpty()) {
                String subStr = stringBuilder.substring(1, stringBuilder.length() - 1);
                result.append(subStr);
                stringBuilder.setLength(0);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Code1021 code1021 = new Code1021();
        System.out.println(code1021.removeOuterParentheses("(()())(())"));
    }
}
