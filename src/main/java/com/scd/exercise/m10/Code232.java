package com.scd.exercise.m10;

import java.util.Stack;

/**
 * @author James
 */
public class Code232 {

    class MyQueue {

        private Stack<Integer> stack;

        private Stack<Integer> tempStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
            tempStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (tempStack.isEmpty() && stack.isEmpty()) {
                throw new IllegalStateException("stack is empty");
            }
            if (tempStack.isEmpty()) {
                while (!stack.isEmpty()) {
                    tempStack.push(stack.pop());
                }
            }
            return tempStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (tempStack.isEmpty() && stack.isEmpty()) {
                throw new IllegalStateException("stack is empty");
            }
            if (tempStack.isEmpty()) {
                while (!stack.isEmpty()) {
                    tempStack.push(stack.pop());
                }
            }
            return tempStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return tempStack.isEmpty() && stack.isEmpty();
        }
    }
}
