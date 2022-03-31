package com.scd.exercise.m10;

import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        List<Integer> dataList = new ArrayList<>();
        while (head != null) {
            dataList.add(head.val);
            head = head.next;
        }
        int dataLen = dataList.size();
        List<Integer> tempList = new ArrayList<>(dataList);
        if (dataLen > 1) {
            for (int i = 0; i < dataLen - 1; i = i + 2) {
                int data = dataList.get(i);
                int next = dataList.get(i+1);
                tempList.set(i, next);
                tempList.set(i+1, data);
            }
        }
        ListNode result = new ListNode();
        ListNode tempNode = result;
        for (Integer integer : tempList) {
            ListNode node = new ListNode(integer);
            tempNode.next = node;
            tempNode = node;
        }
        return result.next;
    }
}
