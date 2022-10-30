package com.scd.exercise.y2022.m9.easy;

import com.scd.exercise.ListCommon;
import com.scd.exercise.ListNode;

import java.util.Arrays;

/**
 * @author James
 */
public class UnionPay1 {

    public ListNode reContruct(ListNode head) {
        while (head != null) {
            if (head.val % 2 == 0) {
                head = head.next;
            } else {
                break;
            }
        }
        ListNode temp = head;
        ListNode pre = temp;
        while (temp != null) {
            if (temp.val % 2 == 0) {
                pre.next = temp.next;
            }
            if (temp.val % 2 != 0) {
                pre = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        UnionPay1 unionPay1 = new UnionPay1();
        ListNode listNode = ListCommon.createList(Arrays.asList(5,4,8,2,6,7,10,1,8));
        unionPay1.reContruct(listNode);
    }
}
