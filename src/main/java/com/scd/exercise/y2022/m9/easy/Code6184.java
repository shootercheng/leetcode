package com.scd.exercise.y2022.m9.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code6184 {
    private static final int[] MONTH_DAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final int[] START_DAY = new int[12];

    static {
        int sum = 0;
        for (int i = 0; i < MONTH_DAY.length; i++) {
            START_DAY[i] = sum;
            sum = sum + MONTH_DAY[i];
        }
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveAliceDay = calDay(arriveAlice);
        int leaveAliceDay = calDay(leaveAlice);
        int arriveBobDay = calDay(arriveBob);
        int leaveBobDay = calDay(leaveBob);
        if (leaveAliceDay < arriveBobDay) {
            return 0;
        }
        if (leaveBobDay < arriveAliceDay) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int i = arriveAliceDay; i <= leaveAliceDay; i++) {
            numSet.add(i);
        }
        int result = 0;
        for (int i = arriveBobDay; i <= leaveBobDay; i++) {
            if (numSet.contains(i)) {
                result++;
            }
        }
        return result;
    }

    private int calDay(String inputDay) {
        String[] inputArr = inputDay.split("-");
        if (inputArr.length != 2) {
            throw new IllegalArgumentException("input param error " + inputDay);
        }
        int month = Integer.parseInt(inputArr[0]);
        int day = Integer.parseInt(inputArr[1]);
        return START_DAY[month - 1] + day;
    }
}
