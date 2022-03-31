package com.scd.exercise;

import java.math.BigInteger;

/**
 * @author James
 */
public class Code445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1 = new StringBuilder();
        while (l1 != null) {
            num1.append(l1.val);
            l1 = l1.next;
        }
        BigInteger bigNum1 = new BigInteger(num1.toString());
        StringBuilder num2 = new StringBuilder();
        while (l2 != null) {
            num2.append(l2.val);
            l2 = l2.next;
        }
        BigInteger bigNum2 = new BigInteger(num2.toString());
        BigInteger result = bigNum1.add(bigNum2);
        String resStr = result.toString();
        char[] resCharArr = resStr.toCharArray();
        ListNode resList = new ListNode();
        ListNode temp = resList;
        for (char c : resCharArr) {
            int i = c - 48;
            ListNode node = new ListNode(i);
            temp.next = node;
            temp = node;
        }
        return resList.next;
    }
}
