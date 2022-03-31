package com.scd.exercise.y2022.m3;

import com.scd.exercise.ListCommon;
import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author James
 */
public class CodeOffer027 {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left++).intValue() != list.get(right--).intValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CodeOffer027 codeOffer027 = new CodeOffer027();
        System.out.println(codeOffer027.isPalindrome(ListCommon.createList(Arrays.asList(1,2,3,3,2,1))));
        System.out.println(codeOffer027.isPalindrome(ListCommon.createList(Arrays.asList(1))));

    }
}
