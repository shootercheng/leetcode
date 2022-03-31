package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1381 {

    static class CustomStack {
        private int[] stackArr;

        private int maxSize;

        private int top;

        private int size;

        public CustomStack(int maxSize) {
            stackArr = new int[maxSize];
            top = 0;
            this.maxSize = maxSize;
            size = 0;
        }

        public void push(int x) {
            if (top == maxSize) {
                return;
            }
            size++;
            stackArr[top++] = x;
        }

        public int pop() {
            if (top == 0) {
                return -1;
            }
            int result = stackArr[top];
            top = top - 1;
            stackArr[top] = 0;
            size--;
            return result;
        }

        public void increment(int k, int val) {
            int min = Math.min(size - 1, k - 1);
            for (int i = 0; i <= min; i++) {
                stackArr[i] = stackArr[i] + val;
            }
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        customStack.pop();
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5, 100);
        customStack.increment(2, 100);
    }
}
