package com.scd.exercise.m12;

import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code147 {

    public ListNode insertionSortList(ListNode head) {
        List<Integer> dataList = new ArrayList<>();
        while (head != null) {
            dataList.add(head.val);
            head = head.next;
        }
        insertSort(dataList);
        ListNode result = new ListNode();
        ListNode temp = result;
        for (Integer val : dataList) {
            ListNode curNode = new ListNode(val);
            temp.next = curNode;
            temp = curNode;
        }
        return result.next;
    }

    public void insertSort(List<Integer> list) {
        int size = list.size();
        for (int i = 1; i < size; i++) {
            int curNum = list.get(i);
            for (int j = 0; j < i; j++) {
                if (curNum < list.get(j)) {
                    list.add(j, curNum);
                    list.remove(i+1);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4,3,2,1));
        Code147 code147 = new Code147();
        code147.insertSort(list);
        System.out.println(list);
    }
}
