package com.scd.exercise.y2022.m10.easy;

/**
 * 判断两个事件是否存在冲突
 */
public class Code6214 {

    public boolean haveConflict(String[] event1, String[] event2) {
        int event1Start = convertToMinute(event1[0]);
        int event1End = convertToMinute(event1[1]);
        int event2Start = convertToMinute(event2[0]);
        int event2End = convertToMinute(event2[1]);
        boolean condition1 = event1Start <= event2Start && event1End >= event2End;
        boolean condition2 = event1Start >= event2Start && event1Start <= event2End;
        boolean condition3 = event1End >= event2Start && event1End <= event2End;
        return condition1 || condition2 || condition3;
    }

    private int convertToMinute(String eventTime) {
        String[] eventArr = eventTime.split(":");
        int hour = Integer.parseInt(eventArr[0]) * 60;
        int minute = Integer.parseInt(eventArr[1]);
        return hour + minute;
    }
}
