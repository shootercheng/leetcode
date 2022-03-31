package com.scd.exercise.m11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author James
 */
public class Code150 {
    private static final List<String> OP_LIST = Collections.unmodifiableList(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {
        Stack<String> strStack = new Stack<>();
        for (String str : tokens) {
            if (!OP_LIST.contains(str)) {
                strStack.push(str);
            } else {
                String num1 = strStack.pop();
                String num2 = strStack.pop();
                String result = calResult(num1, num2, str);
                strStack.push(result);
            }
        }
        if (!strStack.isEmpty()) {
            return Integer.parseInt(strStack.pop());
        }
        return 0;
    }

    private String calResult(String num1, String num2, String op) {
        Integer n1 = Integer.parseInt(num1);
        Integer n2 = Integer.parseInt(num2);
        switch (op) {
            case "+":
                return String.valueOf(n1 + n2);
            case "-":
                return String.valueOf(n1 - n2);
            case "*":
                return String.valueOf(n1 * n2);
            case "/":
                return String.valueOf(n1 / n2);
            default:
                throw new IllegalArgumentException("unknown operator");
        }
    }
}
