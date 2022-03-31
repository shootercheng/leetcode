package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code0206 {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int center = list.size() / 2;
        int j = list.size() - 1;
        for (int i = 0; i < center; i++) {
            if (list.get(i).intValue() != list.get(j)) {
                return false;
            }
            j--;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
