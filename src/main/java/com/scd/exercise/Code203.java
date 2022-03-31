package com.scd.exercise;

import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        ListNode resultHead = new ListNode();
        ListNode resultTemp = resultHead;
        while (temp != null) {
            if (temp.val != val) {
                ListNode curNode = new ListNode(temp.val);
                resultTemp.next = curNode;
                resultTemp = curNode;
            }
            temp = temp.next;
        }
        return resultHead.next;
    }

    public ListNode createListNode(List<Integer> list) {
        ListNode head = new ListNode(list.get(0));
        int size = list.size();
        ListNode temp = head;
        for (int i = 1; i < size; i++) {
            ListNode curNode = new ListNode(list.get(i));
            temp.next = curNode;
            temp = curNode;
        }
        return head;
    }

    public static void main(String[] args) {
        Code203 code203 = new Code203();
        ListNode listNode = code203.createListNode(Arrays.asList(1,1,2,3,1,1));
        ListNode result = code203.removeElements(listNode, 1);
        System.out.println(result);
    }
}
