package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code155 {

    class MinStack {

        private List<Integer> sortedList;

        private Stack<Integer> integerStack;

        /** initialize your data structure here. */
        public MinStack() {
            sortedList = new ArrayList<>();
            integerStack = new Stack<>();

        }

        public void push(int x) {
            integerStack.push(x);
            sortedList.add(x);
            sortedList = sortedList.stream().sorted().collect(Collectors.toList());
        }

        public void pop() {
            Integer result = integerStack.pop();
            sortedList.remove(result);
            sortedList = sortedList.stream().sorted().collect(Collectors.toList());
        }

        public int top() {
            return integerStack.peek();
        }

        public int getMin() {
            return sortedList.get(0);
        }
    }
}
