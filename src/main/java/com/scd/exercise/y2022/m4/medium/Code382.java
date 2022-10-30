package com.scd.exercise.y2022.m4.medium;

import com.scd.exercise.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author James
 */
public class Code382 {

    class Solution {
        private List<Integer> list;

        private Random random;

        public Solution(ListNode head) {
            list = new ArrayList<>();
            random = new Random();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }

}
