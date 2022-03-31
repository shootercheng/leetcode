package com.scd.exercise.m10;

import com.scd.exercise.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code142 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return head;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return null;
    }
}
