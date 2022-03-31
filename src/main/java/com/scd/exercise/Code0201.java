package com.scd.exercise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code0201 {

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> nodeSet = new LinkedHashSet<>();
        while (head.next != null) {
            int val = head.val;
            if (!nodeSet.contains(val)) {
                nodeSet.add(val);
            }
            head = head.next;
        }
        ListNode result = new ListNode();
        ListNode temp = result;
        Iterator<Integer> iterator = nodeSet.iterator();
        while (iterator.hasNext()) {
            ListNode node = new ListNode(iterator.next());
            temp.next = node;
            temp = node;
        }
        return result.next;
    }
}
