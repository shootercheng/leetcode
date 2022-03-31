package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author James
 */
public class Code227 {

    private static Map<String, Integer> OP_MAP = new HashMap<>();

    static {
        OP_MAP.put("+", 1);
        OP_MAP.put("-", 1);
        OP_MAP.put("*", 2);
        OP_MAP.put("/", 2);
    }

    public List<String> convertToPostfix(String input){
        Stack<String> stack = new Stack<>();
        List<String> inputList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, "+-*/", true);
        while (stringTokenizer.hasMoreTokens()) {
            String c = stringTokenizer.nextToken();
            c = c.trim();
            if (c.length() == 0){
                continue;
            }
            if (!OP_MAP.containsKey(c)) {
                inputList.add(c);
            } else {
                // 比较运算符的优先级
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    int curPriority = OP_MAP.get(c);
                    while (true) {
                        if (stack.isEmpty()) {
                            break;
                        }
                        String top = stack.peek();
                        int topPriority = OP_MAP.get(top);
                        if (curPriority > topPriority) {
                            break;
                        }
                        inputList.add(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            inputList.add(stack.pop());
        }
        return inputList;
    }

    public int calculate(String s) {
        List<String> postFix = convertToPostfix(s);
        Stack<String> strStack = new Stack<>();
        for (String str : postFix) {
            if (OP_MAP.containsKey(str)) {
                int num1 = Integer.valueOf(strStack.pop());
                int num2 = Integer.valueOf(strStack.pop());
                int result = calTwoNum(str, num1, num2);
                strStack.push(String.valueOf(result));
            } else {
                strStack.push(str);
            }
        }
        return Integer.valueOf(strStack.pop());
    }

    private int calTwoNum(String op, int num1, int num2) {
        switch (op) {
            case "+":
                return num2 + num1;
            case "-":
                return num2 - num1;
            case "*":
                return num2 * num1;
            case "/":
                return num2 / num1;
            default:
                throw new IllegalArgumentException("unknown op");
        }
    }

    public static void main(String[] args) {
        Code227 code227 = new Code227();
//        System.out.println(code227.calculate("1*2+3"));
//        System.out.println(code227.calculate("3-1+2"));
//        System.out.println(code227.calculate(" 1323 / 32 "));
        System.out.println(code227.calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}
