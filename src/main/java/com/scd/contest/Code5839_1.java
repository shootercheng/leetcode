package com.scd.contest;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author James
 */
public class Code5839_1 {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        int sum = 0;
        for (int p : piles) {
            queue.add(p);
            sum = sum + p;
        }
        while (k > 0 && !queue.isEmpty()) {
            int max = queue.poll();
            int removed = max / 2;
            queue.add(max - removed);
            sum = sum - removed;
            k--;
        }
        return sum;
    }



    public static void main(String[] args) {
    }
}
