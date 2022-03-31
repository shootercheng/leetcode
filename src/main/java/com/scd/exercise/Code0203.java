package com.scd.exercise;

import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code0203 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,5,1,9);
        ListNode node = new ListNode();
        ListNode temp = node;
        for (Integer integer : list) {
            ListNode curNode = new ListNode(integer);
            temp.next = curNode;
            temp = curNode;
        }
        Code0203 code0203 = new Code0203();
        node = node.next;
        code0203.deleteNode(node);
        System.out.println(node);
    }
}
