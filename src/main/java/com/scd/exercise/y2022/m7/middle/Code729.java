package com.scd.exercise.y2022.m7.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code729 {

    static class MyCalendar {
        private static final int EXISTS_FLAG = 1;

        private Map<Integer, Integer> booked;

        public MyCalendar() {
            booked = new HashMap<>();
        }

        public boolean book(int start, int end) {
            for (int i = start; i < end; i++) {
                Integer count = booked.get(i);
                if (count != null) {
                    return false;
                }
            }
            for (int i = start; i < end; i++) {
                booked.put(i, EXISTS_FLAG);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        int[][] arryNum = {{20,29},{13,22},{44,50},{1,7},{2,10},{14,20},{19,25},{36,42},{45,50},{47,50},{39,45},{44,50},{16,25},{45,50},{45,50},{12,20},{21,29},{11,20},{12,17},{34,40},{10,18},{38,44},{23,32},{38,44},{15,20},{27,33},{34,42},{44,50},{35,40},{24,31}};
        for (int[] array : arryNum) {
            System.out.print(myCalendar.book(array[0], array[1]));
            System.out.print(" ");
        }
    }
}
