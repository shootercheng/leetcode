package com.scd.exercise.m11;

import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<Integer> lista = getListData(headA);
        List<Integer> listb = getListData(headB);
        ListNode listNode;
        if (lista.size() > listb.size()) {
            listNode = getTwoListNode(lista, listb);
        } else {
            listNode = getTwoListNode(listb, lista);
        }
        return listNode;
    }

    private ListNode getTwoListNode(List<Integer> llist, List<Integer> slist) {
        int slen = slist.size();
        int llen = llist.size();
        List<Integer> result = new ArrayList<>();
        int i = slen - 1;
        int j = llen - 1;
        while (i >= 0) {
            if (slist.get(i).intValue() == llist.get(j)) {
                result.add(slist.get(i));
            } else {
                break;
            }
            i--;
            j--;
        }
        ListNode resultNode = new ListNode();
        ListNode temp = resultNode;
        for (Integer data : result) {
            ListNode node = new ListNode(data);
            temp.next = node;
            temp = node;
        }
        return resultNode.next;
    }

    private List<Integer> getListData(ListNode listNode) {
        List<Integer> result = new ArrayList<>();
        while (listNode != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }
        return result;
    }
}
