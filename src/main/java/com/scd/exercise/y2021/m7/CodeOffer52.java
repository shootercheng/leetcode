package com.scd.exercise.y2021.m7;

import com.scd.exercise.ListCommon;
import com.scd.exercise.ListNode;
import com.scd.exercise.TreeCommon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class CodeOffer52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            nodeSet.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (nodeSet.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    public static void main(String[] args) {
        CodeOffer52 codeOffer52 = new CodeOffer52();
        ListNode listNodea = ListCommon.createList(Arrays.asList(4,1,8,4,5));
        ListNode listNodeb = ListCommon.createList(Arrays.asList(5,0,1,8,4,5));
        ListNode result = codeOffer52.getIntersectionNode(listNodea, listNodeb);
        System.out.println(result);
    }
}
