package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author James
 */
public class Code933 {

    static class RecentCounter {
        private List<Integer> list;

        public RecentCounter() {
            list = new LinkedList<>();
        }

        public int ping(int t) {
            int size = list.size();
            if (size > 3000) {
                list.remove(0);
            }
            list.add(t);
            int min = t - 3000;
            int minIndex = -1;
            size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) >= min) {
                    minIndex = i;
                    break;
                }
            }

            if (minIndex == -1) {
                throw new IllegalArgumentException("input data error");
            }
            return size - minIndex;
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
