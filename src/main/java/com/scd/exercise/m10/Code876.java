package com.scd.exercise.m10;

import com.scd.exercise.ListCommon;
import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code876 {

    public ListNode middleNode(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int lsize = list.size();
        int ceneter = lsize / 2;
        ListNode result = new ListNode();
        ListNode rtemp = result;
        for (int i = ceneter; i < lsize; i++) {
            ListNode listNode = new ListNode(list.get(i));
            rtemp.next = listNode;
            rtemp = listNode;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Code876 code876 = new Code876();
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        ListNode input = ListCommon.createList(nums);
        ListNode result = code876.middleNode(input);
        System.out.println(result);
    }
}
