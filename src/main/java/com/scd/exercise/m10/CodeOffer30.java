package com.scd.exercise.m10;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author James
 */
public class CodeOffer30 {

    class MinStack {
        private int min = Integer.MAX_VALUE;

        private Stack<Integer> stack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            Integer element = stack.pop();
            if (element == min) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min;
        }
    }
}
