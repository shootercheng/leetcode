package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author James
 */
public class MinStack {
    private List<Integer> list = new ArrayList<>();

    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        list.add(x);
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return -1;
    }
}
