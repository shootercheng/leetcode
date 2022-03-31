package com.scd.exercise.y2022.m3;

import java.util.Stack;

/**
 * @author James
 */
public class Code946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int lenp = pushed.length;
        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex < lenp) {
            if (!stack.isEmpty() && popIndex < lenp && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            } else {
                stack.push(pushed[pushIndex]);
                pushIndex++;
            }
        }
        while (popIndex < lenp) {
            if (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Code946 code946 = new Code946();
        System.out.println(code946.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }
}
