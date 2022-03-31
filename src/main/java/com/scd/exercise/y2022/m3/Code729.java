package com.scd.exercise.y2022.m3;

import java.util.HashMap;
import java.util.Map;

//[null,true,false,true,true,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false]
//[null,true,false,true,true,false,true,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false]
//        ["MyCalendar","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
//        [[],[20,29],[13,22],[44,50],[1,7],[2,10],[14,20],[19,25],[36,42],[45,50],[47,50],[39,45],[44,50],[16,25],[45,50],[45,50],[12,20],[21,29],[11,20],[12,17],[34,40],[10,18],[38,44],[23,32],[38,44],[15,20],[27,33],[34,42],[44,50],[35,40],[24,31]]

/**
 * 729. 我的日程安排表 I
 * @author James
 */
public class Code729 {

    static class MyCalendar {

        private int min;

        private int max;

        public MyCalendar() {
            min = -1;
            max = -1;
        }

        public boolean book(int start, int end) {
            if (min == -1 && max == -1) {
                min = start;
                max = end;
                return true;
            } else {
                boolean result1 = end < min;
                boolean result2 = false;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(13,22);
        myCalendar.book(14,20);
    }
}
