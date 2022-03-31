package com.scd.exercise.y2022.m3;

import java.util.Arrays;

/**
 * @author James
 */
public class Code2037 {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum = 0;
        int lens = seats.length;
        for (int i = 0; i < lens; i++) {
            sum = sum + Math.abs(students[i] - seats[i]);
        }
        return sum;
    }
}
