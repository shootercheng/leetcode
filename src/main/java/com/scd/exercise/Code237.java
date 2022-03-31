package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code237 {

    private ListNode head = new ListNode();

    public void deleteNode(ListNode node) {
        ListNode temp = head;
        if (temp.val == node.val) {
            head = head.next;
            return ;
        }
        ListNode pre = head;
        while (temp != null) {
            if (temp.val == node.val) {
                pre.next = temp.next;
                return ;
            }
            pre = temp;
            temp = temp.next;
        }
    }
}
