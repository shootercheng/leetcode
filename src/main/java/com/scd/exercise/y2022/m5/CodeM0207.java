package com.scd.exercise.y2022.m5;

import com.scd.exercise.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class CodeM0207 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> listNodeSet = new HashSet<>();
        while (headA != null) {
            listNodeSet.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (listNodeSet.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
