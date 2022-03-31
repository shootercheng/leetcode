package com.scd.exercise.y2021.m1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author James
 */
public class MCode0302 {

    class MinStack {
        private Stack<Integer> stack;

        private int min;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
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

        public int getMin() {
            return min;
        }
    }
}
