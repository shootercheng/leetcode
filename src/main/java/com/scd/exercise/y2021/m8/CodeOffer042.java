package com.scd.exercise.y2021.m8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class CodeOffer042 {

    class RecentCounter {
        private List<Integer> requestTimeList = new ArrayList<>();

        private int size = 0;

        public RecentCounter() {
        }

        public int ping(int t) {
            requestTimeList.add(t);
            size++;
            int start = t - 3000;
            int startIndex = -1;
            for (int i = 0; i < size; i++) {
                if (requestTimeList.get(i) >= start) {
                    startIndex = i;
                    break;
                }
            }
            if (startIndex != -1) {
                return size - startIndex;
            }
            return 0;
        }
    }
}
