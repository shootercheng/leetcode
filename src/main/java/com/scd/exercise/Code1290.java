package com.scd.exercise;

import java.util.Arrays;

/**
 * @author James
 */
public class Code1290 {

    public int getDecimalValue(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(stringBuilder.toString(), 2);
    }

    public static void main(String[] args) {
        Code1290 code1290 = new Code1290();
        ListNode head = ListCommon.createList(Arrays.asList(0));
        System.out.println(code1290.getDecimalValue(head));
    }
}
