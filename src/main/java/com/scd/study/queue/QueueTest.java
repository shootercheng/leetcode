package com.scd.study.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author James
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        System.out.println(queue.poll());
    }
}
