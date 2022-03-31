package com.scd.exercise.m11;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author James
 */
public class Code1360 {
    private static final long ONE_HOUR = 60 * 60 * 1000;

    private static final long ONE_DAY = 24 * ONE_HOUR;

    public int daysBetweenDates(String date1, String date2)  {
        try {
            long startTime = getTime(date1);
            long endTime = getTime(date2);
            long result = Math.abs((endTime - startTime)) / ONE_DAY;
            return Integer.valueOf(String.valueOf(result));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private long getTime(String date1) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(date1).getTime();
    }

    public static void main(String[] args) throws ParseException {
        Code1360 code1360 = new Code1360();
//        "1971-06-29"
//        "2010-09-23"
        String date1 = "1971-06-29";
        String date2 = "2010-09-23";
        System.out.println(code1360.daysBetweenDates(date1, date2));
    }
}
