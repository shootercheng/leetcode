package com.scd.exercise.m10;

import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (ListNode listNode : lists) {
            ListNode temp = listNode;
            while (temp != null) {
                list.add(temp.val);
                temp = temp.next;
            }
        }
        list = list.stream().sorted().collect(Collectors.toList());
        ListNode result = new ListNode();
        ListNode rtemp = result;
        for (Integer integer : list) {
            ListNode node = new ListNode(integer);
            rtemp.next = node;
            rtemp = node;
        }
        return result.next;
    }
}
