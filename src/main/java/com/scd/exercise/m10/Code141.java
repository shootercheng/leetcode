package com.scd.exercise.m10;

import com.scd.exercise.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code141 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return false;
    }
}
