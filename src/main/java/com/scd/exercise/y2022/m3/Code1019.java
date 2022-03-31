package com.scd.exercise.y2022.m3;

import com.scd.exercise.ListCommon;
import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code1019 {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int lenl = list.size();
        int[] result = new int[lenl];
        for (int i = 0; i < lenl; i++) {
            boolean isFind = false;
            for (int j = i+1; j < lenl; j++) {
                if (list.get(j) > list.get(i)) {
                    result[i] = list.get(j);
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                result[i] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = ListCommon.createList(Arrays.asList(2,1,5));
        Code1019 code1019 = new Code1019();
        code1019.nextLargerNodes(listNode);
    }
}
