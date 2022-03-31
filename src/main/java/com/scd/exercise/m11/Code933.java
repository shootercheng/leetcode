package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code933 {

    static class RecentCounter {
        private List<Integer> list;

        public RecentCounter() {
            list = new ArrayList<>();
        }

        public int ping(int t) {
            list.add(t);
            int min = t - 3000;
            int minIndex = -1;
            int size = list.size();
            int startIndex = 0;
            if (size > 3000) {
                startIndex = size - 3000;
            }
            for (int i = startIndex; i < size; i++) {
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
