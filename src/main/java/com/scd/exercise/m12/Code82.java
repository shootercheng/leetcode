package com.scd.exercise.m12;

import com.scd.exercise.ListNode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code82 {

    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> dataCountMap = new LinkedHashMap<>();
        while (head != null) {
            Integer count = dataCountMap.computeIfAbsent(head.val, k -> 0);
            dataCountMap.put(head.val, ++count);
            head = head.next;
        }
        Set<Map.Entry<Integer, Integer>> entrySet = dataCountMap.entrySet();
        ListNode result = new ListNode();
        ListNode temp = result;
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                continue;
            }
            ListNode tempNode = new ListNode(entry.getKey());
            temp.next = tempNode;
            temp = tempNode;
        }
        return result.next;
    }
}
