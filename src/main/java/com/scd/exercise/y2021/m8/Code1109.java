package com.scd.exercise.y2021.m8;

/**
 * @author James
 */
public class Code1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            int startIndex = booking[0] - 1;
            int endIndex = booking[1] - 1;
            int seat = booking[2];
            for (int i = startIndex; i <= endIndex; i++) {
                result[i] = result[i] + seat;
            }
        }
        return result;
    }
}
