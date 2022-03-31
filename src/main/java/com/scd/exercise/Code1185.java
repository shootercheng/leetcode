package com.scd.exercise;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code1185 {

    private static final String[] WEEKS_ARR = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    private static Map<Integer, String> WEEK_MAP = new HashMap<>();

    static {
        int len = WEEKS_ARR.length;
        for (int i = 0; i < len; i++) {
            WEEK_MAP.put(i+1, WEEKS_ARR[i]);
        }
    }

    public String dayOfTheWeek(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        return WEEK_MAP.get(weekDay);
    }

    public static void main(String[] args) {
        Code1185 code1185 = new Code1185();
        System.out.println(code1185.dayOfTheWeek(31, 8, 2019));
    }
}
