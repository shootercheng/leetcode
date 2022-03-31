package com.scd.exercise.y2022.m3;

import com.scd.exercise.ListCommon;
import com.scd.exercise.ListNode;

import java.util.Arrays;

/**
 * @author James
 */
public class CodeOffer024 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode curNode = new ListNode(head.val);
            curNode.next = pre;
            head = head.next;
            pre = curNode;

        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = ListCommon.createList(Arrays.asList(1,2,3,4,5));
        CodeOffer024 codeOffer024 = new CodeOffer024();
        codeOffer024.reverseList(listNode);
    }
}
