package com.scd.exercise;

import java.util.Stack;

/**
 * @author James
 */
public class Code206 {

    public ListNode reverseList(ListNode head) {
        ListNode resultList = new ListNode();
        Stack<Integer> valStack = new Stack<>();
        while (head != null) {
            valStack.add(head.val);
            head = head.next;
        }
        ListNode resultTemp = resultList;
        while (!valStack.isEmpty()) {
            Integer curElement = valStack.pop();
            ListNode curNode = new ListNode(curElement);
            resultTemp.next = curNode;
            resultTemp = curNode;
        }
        return resultList.next;
    }

    public static void main(String[] args) {

    }
}
