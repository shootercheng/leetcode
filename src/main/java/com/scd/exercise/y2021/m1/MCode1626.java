package com.scd.exercise.y2021.m1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author James
 */
public class MCode1626 {

    private static Map<String, Integer> operatorPriority = new HashMap<>();

    static {
        operatorPriority.put("(", 0);
        operatorPriority.put("+", 1);
        operatorPriority.put("-", 1);
        operatorPriority.put("*", 2);
        operatorPriority.put("/", 2);
        operatorPriority.put("%", 2);
        operatorPriority.put("^", 4);
    }

    public static boolean isOperator(String c) {
        if (operatorPriority.containsKey(c) || ")".equals(c)) {
            return true;
        }
        return false;
    }

    public static boolean isLeft(String c) {
        return "(".equals(c);
    }

    public static boolean isRight(String c) {
        return ")".equals(c);
    }

    public static List<String> convertToPostfix(List<String> inputList){
        Stack<String> stack = new Stack<>();
        List<String> postFixList = new ArrayList<>(inputList.size());
        for (String c : inputList) {
            if (c.trim().length() == 0){
                continue;
            }
            if (!isOperator(c)) {
                postFixList.add(c);
            } else if (isLeft(c)) {
                stack.push(c);
            } else if (isRight(c)) {
                String top = stack.pop();
                while (!isLeft(top)){
                    postFixList.add(top);
                    top = stack.pop();
                }
            } else if (isOperator(c)) {
                // 比较运算符的优先级
                if (!stack.isEmpty()) {
                    int curPriority = operatorPriority.get(c);
                    while (true) {
                        if (stack.isEmpty()) {
                            break;
                        }
                        String top = stack.peek();
                        int topPriority = operatorPriority.get(top);
                        if (curPriority > topPriority) {
                            break;
                        }
                        postFixList.add(stack.pop());
                    }
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postFixList.add(stack.pop());
        }
        return postFixList;
    }

    public static int calExp(List<String> postfixExp) {
        Stack<Integer> stack = new Stack<>();
        for (String c : postfixExp) {
            if (!isOperator(c)) {
                stack.push(Integer.valueOf(String.valueOf(c)));
            } else {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                Integer result = calTwoNumber(c.charAt(0), num1, num2);
                stack.push(result);
            }
        }
        if (stack.size() == 1) {
            return stack.pop();
        } else {
            throw new RuntimeException("postfixexp error");
        }
    }

    private static Integer calTwoNumber(char c, Integer num1, Integer num2) {
        int result = 0;
        switch (c) {
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num2 / num1;
                break;
            case '%':
                result = num2 % num1;
                break;
            case '^':
                result = (int) Math.pow(num2, num1);
                break;
            default:
                break;
        }
        return result;
    }


    public static List<String> convertInputList(String input){
        StringTokenizer stringTokenizer = new StringTokenizer(input, " +-*/%^()", true);
        List<String> inputList = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String word = stringTokenizer.nextToken();
            if (word.trim().length() == 0) {
                continue;
            }
            inputList.add(word);
        }
        List<String> convertlist = new ArrayList<>(inputList.size());
        for (int i = 0; i < inputList.size(); i++) {
            String str = inputList.get(i);
            if ("-".equals(str)) {
                // 1.负号在表达式最前面
                // 2.负号前面是左括号
                // 3.负号前面是操作符
                if (i == 0 || "(".equals(inputList.get(i-1)) || operatorPriority.containsKey(inputList.get(i-1))) {
                    convertlist.add(str + inputList.get(i+1));
                    i++;
                } else {
                    convertlist.add(str);
                }
            } else {
                convertlist.add(str);
            }
        }
        return convertlist;
    }

    public int calculate(String s) {
        List<String> postFixList = convertToPostfix(convertInputList(s));
        return calExp(postFixList);
    }
}
