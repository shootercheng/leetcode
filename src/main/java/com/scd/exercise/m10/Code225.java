package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code225 {

    class MyStack {
        private List<Integer> queueList;

        /** Initialize your data structure here. */
        public MyStack() {
            queueList = new ArrayList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queueList.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (queueList.size() == 0) {
                throw new IllegalStateException("stack is empty");
            }
            int lastIndex = queueList.size() - 1;
            return queueList.remove(lastIndex);
        }

        /** Get the top element. */
        public int top() {
            if (queueList.size() == 0) {
                throw new IllegalStateException("stack is empty");
            }
            int lastIndex = queueList.size() - 1;
            return queueList.get(lastIndex);
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queueList.size() == 0;
        }
    }
}
