package com.scd.exercise.m10;

import java.util.Stack;

/**
 * @author James
 */
public class Code0304 {

    class MyQueue {

        private Stack<Integer> stack;

        private Stack<Integer> temp;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
            temp = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (empty()) {
                throw new IllegalStateException("queue is empty");
            }
            if (temp.isEmpty()) {
                while (!stack.isEmpty()) {
                    temp.push(stack.pop());
                }
            }
            return temp.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (empty()) {
                throw new IllegalStateException("queue is empty");
            }
            if (temp.isEmpty()) {
                while (!stack.isEmpty()) {
                    temp.push(stack.pop());
                }
            }
            return temp.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return temp.isEmpty() && stack.isEmpty();
        }
    }
}
