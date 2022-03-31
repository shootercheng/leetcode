package com.scd.exercise.y2022.m3;

import com.scd.exercise.ListCommon;
import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author James
 */
public class Code2130_1 {

    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while (head != null) {
            list.add(head.val);
            count++;
            head = head.next;
        }
        int left = count / 2 - 1;
        int right = count / 2;
        int max = Integer.MIN_VALUE;
        for (;left >= 0 && right < count; left--,right++) {
            int curNum = list.get(left) + list.get(right);
            if (curNum > max) {
                max = curNum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Code2130_1 code2130_1 = new Code2130_1();
        ListNode listNode = ListCommon.createList(Arrays.asList(1,2,3,4));
        code2130_1.pairSum(listNode);
    }
}
