package com.scd.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 == null) {
            return l1;
        }
        List<ListNode> resultList = new ArrayList<>();
        while (l1!= null) {
            resultList.add(new ListNode(l1.val));
            l1 = l1.next;
        }
        while (l2 != null) {
            resultList.add(new ListNode(l2.val));
            l2 = l2.next;
        }
        resultList = resultList.stream().sorted(Comparator.comparing(l -> l.val)).collect(Collectors.toList());
        ListNode result = resultList.get(0);
        ListNode temp = result;
        for (int i = 1; i < resultList.size(); i++) {
            ListNode curNode = resultList.get(i);
            temp.next = curNode;
            temp = curNode;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
