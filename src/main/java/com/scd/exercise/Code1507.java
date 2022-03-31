package com.scd.exercise;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code1507 {

    private static String[] MONTH = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private static final Map<String, Integer> MONTH_MAP = new HashMap<>();

    static {
        int len = MONTH.length;
        for (int i = 0; i < len; i++) {
            MONTH_MAP.put(MONTH[i], i+1);
        }
    }

    public String reformatDate(String date) {
        String[] dateArr = date.split("\\s+");
        if (dateArr.length != 3) {
            return "";
        }
        int year = Integer.parseInt(dateArr[2]);
        int month = MONTH_MAP.get(dateArr[1]);
        String dayStr = dateArr[0];
        int day = Integer.parseInt(dayStr.substring(0, dayStr.length() - 2));
        String strMonth = "";
        if (month < 10) {
            strMonth = "0" + month;
        } else {
            strMonth = strMonth + month;
        }
        String strDay = "";
        if (day < 10) {
            strDay = "0" + day;
        } else {
            strDay = strDay + day;
        }
        return year + "-" + strMonth + "-" + strDay;
    }

    public static void main(String[] args) {
    }
}
