package com.scd.exercise.m10;

import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code148 {

    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list = list.stream().sorted().collect(Collectors.toList());
        ListNode result = new ListNode();
        ListNode temp = result;
        for (Integer integer : list) {
            ListNode listNode = new ListNode(integer);
            temp.next = listNode;
            temp = listNode;
        }
        return result.next;
    }
}
