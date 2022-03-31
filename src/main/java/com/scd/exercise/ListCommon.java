package com.scd.exercise;

import java.util.List;

/**
 * @author James
 */
public class ListCommon {

    public static ListNode createList(List<Integer> nums) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (Integer num : nums) {
            ListNode curNode = new ListNode(num);
            temp.next = curNode;
            temp = curNode;
        }
        return head.next;
    }
}
