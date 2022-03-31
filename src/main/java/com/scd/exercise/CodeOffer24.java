package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class CodeOffer24 {

    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        ListNode result = new ListNode();
        ListNode temp = result;
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            ListNode curNode = new ListNode(list.get(i));
            temp.next = curNode;
            temp = curNode;
        }
        return result.next;
    }
}
