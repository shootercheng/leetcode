package com.scd.exercise.y2022.m9.easy;

public class Code2437 {
    public int countTime(String time) {
        String[] timeArr = time.split(":");
        String hour = timeArr[0];
        String minute = timeArr[1];
        char[] hourCharArr = hour.toCharArray();
        char[] minuteCharArr = minute.toCharArray();
        int sum = 1;
        if (hourCharArr[0] == '?') {
            if (hourCharArr[1] == '?') {
                sum = sum * 24;
            } else {
                if (hourCharArr[1] == '0' || hourCharArr[1] == '1' ||
                        hourCharArr[1] == '2' || hourCharArr[1] == '3') {
                    sum = sum * 3;
                } else {
                    sum = sum * 2;
                }
            }
        } else {
            if (hourCharArr[1] == '?') {
                if (hourCharArr[0] == '0' || hourCharArr[0] == '1') {
                    sum = sum * 10;
                } else if (hourCharArr[0] == '2') {
                    sum = sum * 4;
                }
            }
        }
        if (minuteCharArr[0] == '?') {
            sum = sum * 6;
        }
        if (minuteCharArr[1] == '?') {
            sum = sum * 10;
        }
        return sum;
    }
}
