package com.scd.exercise;

import java.util.Stack;

/**
 * @author James
 */
public class CodeOffer09 {

    Stack<Integer> stackA = new Stack<>();

    Stack<Integer> stackB = new Stack<>();

    public void appendTail(int value) {
        stackA.push(value);
    }

    public int deleteHead() {
        if (stackA.isEmpty() && stackB.isEmpty()) {
            return -1;
        }
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                Integer ele = stackA.pop();
                stackB.push(ele);
            }
        }
        return stackB.pop();
    }
}
