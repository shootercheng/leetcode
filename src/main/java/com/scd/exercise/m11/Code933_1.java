package com.scd.exercise.m11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class Code933_1 {

    static class RecentCounter {
        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            int size = queue.size();
            if (size > 3001) {
                queue.poll();
            }
            queue.offer(t);
            size = queue.size();
            int min = t - 3000;
            Iterator<Integer> iterator = queue.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                if (iterator.next() >= min) {
                    break;
                }
                i++;
            }
            return size - i;
        }
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}
