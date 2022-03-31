package com.scd.exercise.y2021.m7;

import com.scd.exercise.ListCommon;
import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int lenl = list.size();
        int[] numArr = new int[lenl];
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < lenl; i++) {
            numArr[i] = list.get(i);
            if (i >= m - 1 && i <= n - 1) {
                tempList.add(numArr[i]);
            }
        }
        int j = m - 1;
        for (int i = tempList.size() - 1; i >= 0; i--) {
            numArr[j++] = tempList.get(i);
        }
        ListNode result = new ListNode();
        ListNode temp = result;
        int index = 0;
        for (Integer num : list) {
            temp.next = new ListNode(numArr[index++]);
            temp = temp.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListCommon.createList(Arrays.asList(1,2,3,4,5));
        Code92 code92 = new Code92();
        ListNode result = code92.reverseBetween(listNode, 2, 4);
        System.out.println(result);
    }
}
