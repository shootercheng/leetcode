package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code19 {

    public ListNode removeEndIndex(ListNode head, int n) {
        int i = 1;
        ListNode temp = head;
        List<ListNode> listNodes = new ArrayList<>();
        while (temp != null) {
            listNodes.add(new ListNode(temp.val));
            temp = temp.next;
            i++;
        }
        int removeKey = i - n;
        if (removeKey < 1) {
            return head;
        }
        // 第一个节点
        if (removeKey == 1) {
            head = head.next;
            return head;
        } else {
            listNodes.remove(removeKey - 1);
        }
        if (listNodes.size() > 0) {
            ListNode firstNode = listNodes.get(0);
            ListNode tempNode = firstNode;
            int size = listNodes.size();
            for (int j = 1; j < size; j++) {
                ListNode curNode = listNodes.get(j);
                tempNode.next = curNode;
                tempNode = curNode;
            }
            return firstNode;
        }
        return head;
    }

    private ListNode createListNode(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return new ListNode();
        }
        ListNode listNode = new ListNode(list.get(0));
        ListNode temp = listNode;
        for (int i = 1; i < list.size(); i++) {
            ListNode curNode = new ListNode(list.get(i));
            temp.next = curNode;
            temp = curNode;
        }
        return listNode;
    }

    public static void main(String[] args) {
        Code19 code19 = new Code19();
        List<Integer> list = Arrays.asList(1,2,3);
        ListNode l = code19.createListNode(list);
        ListNode result = code19.removeEndIndex(l, 3);
        System.out.println(result);
    }
}
