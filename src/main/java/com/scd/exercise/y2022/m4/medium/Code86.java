package com.scd.exercise.y2022.m4.medium;

import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 86. 分隔链表
 * @author James
 */
public class Code86 {

    public ListNode partition(ListNode head, int x) {
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        while (head != null) {
            if (head.val < x) {
                left.add(head.val);
            } else if (head.val == x) {
                equal.add(head.val);
            } else {
                right.add(head.val);
            }
            head = head.next;
        }
        List<Integer> dataList = new ArrayList<>();
        dataList.addAll(left);
        dataList.addAll(equal);
        dataList.addAll(right);
        ListNode result = new ListNode();
        ListNode temp = result;
        for (Integer val : dataList) {
            ListNode curNode = new ListNode(val);
            temp.next = curNode;
            temp = curNode;
        }
        return result.next;
    }
}
