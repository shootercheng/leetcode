package com.scd.exercise.m10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class CodeOffer59 {

    static class MaxQueue {

        private Queue<Integer> queue;

        private int maxValue;

        private int size = 0;

        public MaxQueue() {
            queue = new ArrayDeque<>();
        }

        public int max_value() {
            if (size == 0) {
                return -1;
            }
            return maxValue;
        }

        public void push_back(int value) {
            size++;
            queue.offer(value);
            if (value > maxValue) {
                maxValue = value;
            }
        }

        public int pop_front() {
            if (size == 0) {
                return -1;
            }
            Integer front = queue.poll();
            size--;
            if (front == maxValue) {
                int max = Integer.MIN_VALUE;
                Iterator<Integer> iterator = queue.iterator();
                while (iterator.hasNext()) {
                    int data = iterator.next();
                    if (data > max) {
                        max = data;
                    }
                }
                maxValue = max;
            }
            return front;
        }
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(3);
        maxQueue.push_back(2);
        maxQueue.push_back(1);
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
    }
}
