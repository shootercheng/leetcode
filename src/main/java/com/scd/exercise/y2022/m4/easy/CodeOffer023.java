package com.scd.exercise.y2022.m4.easy;

import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class CodeOffer023 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> listA = getList(headA);
        List<ListNode> listB = getList(headB);
        int indexA = listA.size() - 1;
        int indexB = listB.size() - 1;
        List<ListNode> newList = new ArrayList<>();
        while (indexA >= 0 && indexB >= 0) {
            if (listA.get(indexA) != listB.get(indexB)) {
                break;
            } else {
                ListNode curNode = listA.get(indexA);
                curNode.next = null;
                newList.add(curNode);
            }
            indexA--;
            indexB--;
        }
        int lenn = newList.size() - 1;
        ListNode result = new ListNode();
        ListNode temp = result;
        for (int i = lenn; i >= 0; i--) {
            ListNode curNode = newList.get(i);
            temp.next = curNode;
            temp = curNode;
        }
        return result.next;
    }

    private List<ListNode> getList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list;
    }
}
