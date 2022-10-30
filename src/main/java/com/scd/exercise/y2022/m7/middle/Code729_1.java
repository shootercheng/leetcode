package com.scd.exercise.y2022.m7.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code729_1 {

    static class MyCalendar {
        private List<int[]> arrayList;

        public MyCalendar() {
            arrayList = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] array : arrayList) {
                if (start >= array[0] && start <= array[1]) {
                    return false;
                }
                int maxEnd = end - 1;
                if (maxEnd >= array[0] && maxEnd <= array[1]) {
                    return false;
                }
                if (start <= array[0] && maxEnd >= array[1]) {
                    return false;
                }
            }
            arrayList.add(new int[]{start, end - 1});
            return true;
        }
    }

    public static void main(String[] args) {
        Code729_1.MyCalendar myCalendar = new Code729_1.MyCalendar();
        int[][] arryNum = {{97,100},{33,51},{89,100},{83,100},{75,92},{76,95},{19,30},{53,63},{8,23},{18,37},{87,100},{83,100},{54,67},{35,48},{58,75},{70,89},{13,32},{44,63},{51,62},{2,15}};
        for (int[] array : arryNum) {
            System.out.print(myCalendar.book(array[0], array[1]));
            System.out.print(" ");
        }
    }
}
