package com.scd.contest;

import com.scd.exercise.ListCommon;
import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code5652 {

    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head.val);
            head = head.next;
        }
        int startIndex = k - 1;
        int endIndex = nodeList.size() - k;
        int temp = nodeList.get(startIndex);
        nodeList.set(startIndex, nodeList.get(endIndex));
        nodeList.set(endIndex, temp);
        ListNode result = new ListNode();
        ListNode rTemp = result;
        for (Integer val : nodeList) {
            ListNode curNode = new ListNode(val);
            rTemp.next = curNode;
            rTemp = curNode;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Code5652 code5652 = new Code5652();
        ListNode listNode = ListCommon.createList(Arrays.asList(1,2,3,4,5));
        code5652.swapNodes(listNode, 2);
    }
}
