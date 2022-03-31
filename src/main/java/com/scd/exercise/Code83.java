package com.scd.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class Code83 {

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> numSet = new LinkedHashSet<>();
        while (head != null) {
            int val = head.val;
            numSet.add(val);
            head = head.next;
        }
        ListNode result = new ListNode();
        ListNode temp = result;
        Iterator<Integer> iterator = numSet.iterator();
        while (iterator.hasNext()) {
            ListNode node = new ListNode(iterator.next());
            temp.next = node;
            temp = node;
        }
        return result.next;
    }

    public ListNode createListNode(List<Integer> list) {
        ListNode listNode = new ListNode(list.get(0));
        ListNode temp = listNode;
        for (int i = 1; i < list.size(); i++) {
            ListNode curNode = new ListNode(list.get(i));
            temp.next = curNode;
            temp = curNode;
        }
        return listNode;
    }

    public static void main(String[] args) {
        Code83 code83 = new Code83();
        ListNode listNode = code83.createListNode(Arrays.asList(1,1,1));
        ListNode resultList = code83.deleteDuplicates(listNode);
        System.out.println(resultList);
    }
}
