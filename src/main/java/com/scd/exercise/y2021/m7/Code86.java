package com.scd.exercise.y2021.m7;

import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code86 {
    /**
     * 1   4   3    2    5   2
     * 1   2   3    4    5   2
     *
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            head = head.next;
            list.add(head.val);
        }
        int lsize = list.size();
        for (int i = 0; i < lsize; i++) {
            int curNum = list.get(i);
            if (curNum > x) {

            }
        }
        return head;
    }
}
