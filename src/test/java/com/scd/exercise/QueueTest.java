package com.scd.exercise;

import org.junit.Test;

import java.util.PriorityQueue;

public class QueueTest {

    @Test
    public void testPriorityQueue() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(4);
        priorityQueue.add(2);
        System.out.println(priorityQueue);
    }
}
