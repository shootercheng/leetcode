package com.scd.exercise.y2022.m3;

import com.scd.exercise.ListCommon;
import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code2181 {

    public ListNode mergeNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int temp = 0;
        head = head.next;
        while (head != null) {
            if (head.val != 0) {
                temp = temp + head.val;
            } else {
                list.add(temp);
                temp = 0;
            }
            head = head.next;
        }
        ListNode listNode = new ListNode();
        ListNode tempList = listNode;
        for (Integer node : list) {
            ListNode curNode = new ListNode(node);
            tempList.next = curNode;
            tempList = curNode;
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        Code2181 code2181 = new Code2181();
        code2181.mergeNodes(ListCommon.createList(Arrays.asList(0,3,1,0,4,5,2,0)));
    }
}
