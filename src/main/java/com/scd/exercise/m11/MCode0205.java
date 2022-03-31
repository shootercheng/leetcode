package com.scd.exercise.m11;

import com.scd.exercise.ListCommon;
import com.scd.exercise.ListNode;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author James
 */
public class MCode0205 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        BigInteger bigInteger1 = convertToListBigInt(l1);
        BigInteger bigInteger2 = convertToListBigInt(l2);
        BigInteger result = bigInteger1.add(bigInteger2);
        char[] chars = result.toString().toCharArray();
        ListNode resultList = new ListNode();
        ListNode temp = resultList;
        int lenc = chars.length;
        for (int i = lenc - 1; i >= 0; i--) {
            ListNode curNode = new ListNode(chars[i] - 48);
            temp.next = curNode;
            temp = curNode;
        }
        return resultList.next;
    }

    private BigInteger convertToListBigInt(ListNode l) {
        StringBuilder stringBuilder = new StringBuilder();
        while (l != null) {
            stringBuilder.insert(0, l.val);
            l = l.next;
        }
        return new BigInteger(stringBuilder.toString());
    }

    public static void main(String[] args) {
        MCode0205 mCode0205 = new MCode0205();
        ListNode l1 = ListCommon.createList(Arrays.asList(7,1,6));
        ListNode l2 = ListCommon.createList(Arrays.asList(5,9,2));
        mCode0205.addTwoNumbers(l1, l2);
    }
}
