package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class CodeOffer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int startIndex = size - k;
        ListNode result = new ListNode();
        ListNode temp = result;
        for (int i = startIndex; i < size; i++) {
            ListNode curNode = new ListNode(list.get(i));
            temp.next = curNode;
            temp = curNode;
        }
        return result.next;
    }
}
