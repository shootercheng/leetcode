package com.scd.exercise.m11;

import java.util.Stack;

/**
 * @author James
 */
public class Code1009 {

    public int bitwiseComplement(int N) {
        Stack<Integer> stack = new Stack<>();
        int temp = N / 2;
        int mod = N % 2;
        stack.push(mod);
        while (temp >= 2) {
            mod = temp % 2;
            temp = temp / 2;
            stack.push(mod);
        }
        if (temp != 0) {
            stack.push(temp);
        }
        int start = stack.size() - 1;
        int sum = 0;
        while (!stack.isEmpty()) {
            int ele = 1 - stack.pop();
            sum = sum + ele * pow(2, start);
            start--;
        }
        return sum;
    }

    public int pow(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result = result * a;
        }
        return result;
    }

    public static void main(String[] args) {
        Code1009 code1009 = new Code1009();
        System.out.println(code1009.bitwiseComplement(10));
    }
}
