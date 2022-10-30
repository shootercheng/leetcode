package com.scd.exercise.y2022.m7.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的日程安排表 II
 * @author James
 */
public class Code731 {

    class MyCalendarTwo {
        private List<int[]> arrayList;

        public MyCalendarTwo() {
            arrayList = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            int count = 0;
            for (int[] array : arrayList) {
                if (start >= array[0] && start <= array[1]) {
                    count++;
                    continue;
                }
                int maxEnd = end - 1;
                if (maxEnd >= array[0] && maxEnd <= array[1]) {
                    count++;
                    continue;
                }
                if (start <= array[0] && maxEnd >= array[1]) {
                    count++;
                    continue;
                }
            }
            if (count > 1) {
                return false;
            }
            arrayList.add(new int[]{start, end - 1});
            return true;
        }
    }
}
