package com.scd.exercise;

import java.util.Stack;

/**
 * @author James
 */
public class Code504 {

    public String convertToBase7(int num) {
        String prefix = "";
        if (num < 0) {
            prefix = "-";
            num = - num;
        }
        Stack<Integer> stack = new Stack<>();
        int temp = num;
        while (temp >= 7) {
            int mod = temp % 7;
            temp = temp / 7;
            stack.push(mod);
        }
        stack.push(temp);
        StringBuilder stringBuilder = new StringBuilder(prefix);
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String result = Integer.toString(-7, 7);
        System.out.println(result);
        int i = 0 % 7;
        int j = 1 % 7;
        System.out.println(i);
        System.out.println(j);
        Code504 code504 = new Code504();
        System.out.println(code504.convertToBase7(-7));
        System.out.println(code504.convertToBase7(1));
        System.out.println(code504.convertToBase7(-7).equals(Integer.toString(-7, 7)));
        System.out.println(code504.convertToBase7(1).equals(Integer.toString(1, 7)));
    }
}
