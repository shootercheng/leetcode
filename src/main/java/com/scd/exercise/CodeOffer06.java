package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class CodeOffer06 {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] result = new int[list.size()];
        int loopStart = list.size() - 1;
        int j = 0;
        for (int i = loopStart; i >= 0; i--) {
            result[j++] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] origin = {1,2,3,4,5};
        int[] target = new int[10];
        System.arraycopy(origin, 0, target, 5, 5);
        System.out.println(target);
    }
}
