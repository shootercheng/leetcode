package com.scd.exercise.y2022.m3;

import com.scd.exercise.ListNode;

import java.util.Stack;

/**
 * @author James
 */
public class Code2130 {

    public int pairSum(ListNode head) {
        Stack<Integer> integerStack = new Stack<>();
        int count = 0;
        while (head != null) {
            integerStack.push(head.val);
            count++;
            head = head.next;
        }
        Stack<Integer> others = new Stack<>();
        int loop = count / 2;
        for (int i = 0; i < loop; i++) {
            others.push(integerStack.pop());
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < loop; i++) {
            int curNum = integerStack.pop() + others.pop();
            if (curNum > max) {
                max = curNum;
            }
        }
        return max;
    }
}
