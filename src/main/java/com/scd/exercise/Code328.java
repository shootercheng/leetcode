package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code328 {

    public ListNode oddEvenList(ListNode head) {
        int start = 1;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (head != null) {
            int val = head.val;
            if (start % 2 == 0) {
                list2.add(val);
            } else {
                list1.add(val);
            }
            head = head.next;
            start++;
        }
        ListNode result = new ListNode();
        ListNode temp = result;
        list1.addAll(list2);
        appendList(temp, list1);
        return result.next;
    }

    private void appendList(ListNode temp, List<Integer> list) {
        for (Integer integer : list) {
            ListNode node = new ListNode(integer);
            temp.next = node;
            temp = node;
        }
    }

    public static void main(String[] args) {

    }
}
