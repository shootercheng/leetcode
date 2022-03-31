package com.scd.exercise.m11;

import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code539 {
    private static final int ONE_DAY = 24 * 60;

    public int findMinDifference(List<String> timePoints) {
        int[] minuteArr = new int[ONE_DAY];
        for (String time : timePoints) {
            int minute = calMinute(time);
            if (minute != -1) {
                int arrIndex = minute - 1;
                minuteArr[arrIndex]++;
                if (minuteArr[arrIndex] == 2) {
                    return 0;
                }
            }
        }
        int i = 0;
        int first = findNextIndex(minuteArr, i);
        int pre = first;
        int min = Integer.MAX_VALUE;
        while (i < ONE_DAY) {
            int next = findNextIndex(minuteArr, pre + 1);
            if (next == -1) {
                break;
            }
            int dis = next - pre;
            if (dis < min) {
                min = dis;
            }
            pre = next;
            i = next + 1;
        }
        int last = pre;
        // 23:59 00:01
        int reverseDis = ONE_DAY - last + first;
        if (reverseDis < min) {
            min = reverseDis;
        }
        return min;
    }

    public int calMinute(String time) {
        if ("00:00".equals(time)) {
            return ONE_DAY;
        }
        int index = time.indexOf(":");
        if (index != -1) {
            int hour = Integer.parseInt(time.substring(0, index));
            int minute = Integer.parseInt(time.substring(index+1));
            return hour * 60 + minute;
        }
        return -1;
    }

    public int findNextIndex(int[] minuteArr, int startIndex) {
        for (int i = startIndex; i < ONE_DAY; i++) {
            if (minuteArr[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Code539 code539 = new Code539();
        String time = "23:59";
        System.out.println(code539.calMinute(time));
        List<String> inputList = Arrays.asList("05:31","22:08","00:35");
        // 331 1328 35
        // 1440 - 1328 + 35
        System.out.println(code539.findMinDifference(inputList));
    }

}
