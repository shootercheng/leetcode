package com.scd.exercise.y2022.m4.medium;

import com.scd.exercise.ListCommon;
import com.scd.exercise.ListNode;
import com.scd.exercise.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 61. 旋转链表
 * @author James
 */
public class Code61 {

    public ListNode rotateRight(ListNode head, int k) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int lenn = nums.size();
        if (lenn == 0) {
            return head;
        }
        k = k  % lenn;
        Integer[] numArr = new Integer[lenn];
        nums.toArray(numArr);
        for (int i = 0; i < k; i++) {
            moveRight(numArr);
        }
        ListNode result = new ListNode();
        ListNode temp = result;
        for (Integer num : numArr) {
            ListNode curNode = new ListNode(num);
            temp.next = curNode;
            temp = curNode;
        }
        return result.next;
    }

    private void moveRight(Integer[] nums) {
        int lenn = nums.length;
        int temp = nums[lenn - 1];
        for (int i = lenn - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        Code61 code61 = new Code61();
        ListNode listNode = ListCommon.createList(Arrays.asList(1,2,3,4,5));
        code61.rotateRight(listNode, 2);
    }
}
