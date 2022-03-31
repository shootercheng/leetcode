package com.scd.exercise.y2021.m1;

import com.scd.exercise.ListNode;

/**
 * @author James
 */
public class Code1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = null;
        ListNode end = null;
        ListNode temp = list1;
        int startIndex = 0;
        while (temp.next != null) {
            startIndex++;
            if (startIndex == a) {
                start = temp;
            } else if (startIndex == b+1) {
                end = temp;
            }
            temp = temp.next;
        }
        if (start != null) {
            start.next = list2;
        }
        while (list2.next != null) {
            list2 = list2.next;
        }
        if (end != null) {
            list2.next = end;
        }
        return list1;
    }
}
