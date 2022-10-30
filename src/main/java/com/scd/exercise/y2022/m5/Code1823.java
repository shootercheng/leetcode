package com.scd.exercise.y2022.m5;

import com.scd.exercise.ListNode;

/**
 * 1823. 找出游戏的获胜者
 * @author James
 */
public class Code1823 {

//    class ListNode {
//        public int val;
//        public ListNode next;
//
//        public ListNode(int x) {
//            val = x;
//        }
//
//        public ListNode() {
//        }
//    }

    public int findTheWinner(int n, int k) {
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        for (int i = 1; i <= n; i++) {
            ListNode curNode = new ListNode(i);
            temp.next = curNode;
            temp = curNode;
        }
        ListNode firstNode = listNode.next;
        temp.next = firstNode;
        int count = 0;
        ListNode preNode = temp;
        ListNode moveNode = temp;
        while (moveNode.next != moveNode) {
            moveNode = moveNode.next;
            count++;
            if (count == k) {
                preNode.next = moveNode.next;
                count = 0;
            }
            preNode = moveNode;
        }
        return moveNode.val;
    }

    public int findTheWinner2(int n, int k) {
        if (k == 1) {
            return n;
        }
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        for (int i = 1; i <= n; i++) {
            ListNode curNode = new ListNode(i);
            temp.next = curNode;
            temp = curNode;
        }
        ListNode firstNode = listNode.next;
        temp.next = firstNode;
        int count = 1;
        ListNode preNode = firstNode;
        ListNode moveNode = firstNode;
        while (moveNode.next != moveNode) {
            moveNode = moveNode.next;
            count++;
            if (count == k) {
                preNode.next = moveNode.next;
                count = 1;
                moveNode = moveNode.next;
            }
            preNode = moveNode;
        }
        return moveNode.val;
    }

    public static void main(String[] args) {
        Code1823 code1823 = new Code1823();
        code1823.findTheWinner2(3,1);
    }
}
