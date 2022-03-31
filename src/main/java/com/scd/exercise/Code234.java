package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code234 {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int center = list.size() / 2;
        int j = list.size() - 1;
        for (int i = 0; i < center; i++,j--) {
            if (list.get(i).intValue() != list.get(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,2,1);
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        for (Integer i : list) {
            ListNode curNode = new ListNode(i);
            temp.next = curNode;
            temp = curNode;
        }
        Code234 code234 = new Code234();
        System.out.println(code234.isPalindrome(listNode.next));
    }
}
