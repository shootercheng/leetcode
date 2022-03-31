package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code21_1 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode headNode = new ListNode(0);
        ListNode tailNode = headNode;
        while (true) {
            if (l1 == null && l2 == null) {
                break;
            }
            if (l1 != null && l2 != null && l2.val < l1.val) {
                ListNode curNode = new ListNode(l2.val);
                tailNode.next = curNode;
                tailNode = curNode;
                l2 = l2.next;
            } else if (l1 != null) {
                ListNode curNode = new ListNode(l1.val);
                tailNode.next = curNode;
                tailNode = curNode;
                l1 = l1.next;
            } else {
                if (l2 != null) {
                    ListNode curNode = new ListNode(l2.val);
                    tailNode.next = curNode;
                    tailNode = curNode;
                    l2 = l2.next;
                }
            }
        }
        headNode = headNode.next;
        return headNode;
    }

    private ListNode createListNode(List<Integer> nodeList) {
        ListNode firstNode = new ListNode(nodeList.get(0));
        ListNode temp = firstNode;
        for (int i = 1; i < nodeList.size(); i++) {
            ListNode curNode = new ListNode(nodeList.get(i));
            temp.next = curNode;
            temp = curNode;
        }
        return firstNode;
    }

    public static void main(String[] args) {
        Code21_1 code211 = new Code21_1();
        ListNode l1 = code211.createListNode(Arrays.asList(1,2,4));
        ListNode l2 = code211.createListNode(Arrays.asList(1,3,4));
        ListNode result = code211.mergeTwoLists(null, l2);
        System.out.println(result);
    }
}
