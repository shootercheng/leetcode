package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code0202 {

    public int kthToLast(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            int val = head.val;
            list.add(val);
            head = head.next;
        }
        int size = list.size();
        if (k < size) {
            return list.get(size - k);
        }
        return 0;
    }
}
