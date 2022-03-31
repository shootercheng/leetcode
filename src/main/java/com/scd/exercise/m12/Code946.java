package com.scd.exercise.m12;

import java.util.Stack;

/**
 * @author James
 */
public class Code946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        int lenp = popped.length;
        int pushIndex = 0;
        int pushlength = pushed.length;
        while (p < lenp) {
            while (popped[p] != pushed[pushIndex]) {
                if (pushIndex == pushlength) {
                    return false;
                }
                stack.push(pushed[pushIndex]);
                pushIndex++;
            }
            p++;
        }
        return false;
    }
}
