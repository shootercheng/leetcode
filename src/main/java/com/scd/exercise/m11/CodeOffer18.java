package com.scd.exercise.m11;

import com.scd.exercise.ListNode;

/**
 * @author James
 */
public class CodeOffer18 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode temp = head;
        ListNode pre = null;
        while (temp != null) {
            if (temp.val == val) {
                if (pre == null) {
                    head = head.next;
                } else {
                    pre.next = temp.next;
                }
                break;
            }
            pre = temp;
            temp = temp.next;
        }
        return head;
    }
}
