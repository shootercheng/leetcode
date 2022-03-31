package com.scd.exercise.m10;

import java.util.Calendar;
import java.util.Date;

/**
 * @author James
 */
public class Code1154 {

    private static final long ONE_HOUR = 3600 * 1000;

    private static final long ONE_DAY = 24 * ONE_HOUR;

    public int dayOfYear(String date) {
        String[] dateArr = date.split("-");
        Calendar calendar = Calendar.getInstance();
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        calendar.set(year, month - 1, day);
        long currentTime = calendar.getTimeInMillis();
        Calendar start = Calendar.getInstance();
        start.set(year, Calendar.JANUARY, 1);
        long startTime = start.getTimeInMillis();
        return (int) ((currentTime - startTime + ONE_HOUR) / ONE_DAY);
    }

    public static void main(String[] args) {
        String inputDate = "2020-01-02";
        Code1154 code1154 = new Code1154();
        System.out.println(code1154.dayOfYear(inputDate));
        Date date = new Date();
    }
}
