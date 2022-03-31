package com.scd.exercise;

import java.math.BigInteger;
import java.util.List;

/**
 * @author James
 */
public class TwoNumAdd {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger lt1 = getReverseInt(l1);
        BigInteger lt2 = getReverseInt(l2);
        BigInteger lt3 = lt1.add(lt2);
        return convertIntToList(lt3);
    }

    public BigInteger getReverseInt(ListNode l) {
        StringBuilder builder = new StringBuilder("");
        while(l != null) {
            builder.append(l.val);
            l = l.next;
        }
        BigInteger bigInteger = new BigInteger(builder.reverse().toString());
        return bigInteger;
    }

    public ListNode convertIntToList(BigInteger l) {
        String str = String.valueOf(l);
        char[] charArr = str.toCharArray();
        int first =  charArr.length - 1;
        ListNode list = new ListNode( (int) charArr[first] - 48);
        int loopStart = first - 1;
        ListNode temp = list;
        for (int i = loopStart; i >= 0; i--) {
            ListNode curNode = new ListNode((int) charArr[i] - 48);
            temp.next = curNode;
            temp = curNode;
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(3);
        l1.next = l1_1;
        l1_1.next = l1_2;
        ListNode l2 = new ListNode(5);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(4);
        l2.next = l2_1;
        l2_1.next = l2_2;
        TwoNumAdd twoNumAdd = new TwoNumAdd();
        twoNumAdd.addTwoNumbers(l1, l2);
        int i = Integer.valueOf("9999999991");
        System.out.println(i);
    }
}
