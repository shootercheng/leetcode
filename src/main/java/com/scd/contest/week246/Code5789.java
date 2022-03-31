package com.scd.contest.week246;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code5789 {
    private static List<Integer> timeList = new ArrayList<>();
    private static Map<String, Integer> timeMap = new LinkedHashMap<>();

    static {
        for (int i = 0; i <= 23; i++) {
            for (int j = 0; j < 60; j = j + 15) {
                int time = i * 60 + j;
                timeList.add(time);
                String timeStr = i + ":" + j;
                timeMap.put(timeStr, time);
            }
        }
    }

    public int numberOfRounds(String startTime, String finishTime) {
        int startInt = convertTimeToInt(startTime);
        int finishInt = convertTimeToInt(finishTime);
        if (startInt == finishInt) {
            return 0;
        }
        if (startInt < finishInt) {
            return countTimeIndex(startInt, finishInt);
        } else {
            // (finish, 23:59] [00:00 startTime]
            int fstartInt = convertTimeToInt(startTime);
            int countEnd = 0;
            // [23:45, 00:00]
            if (fstartInt <= timeList.get(timeList.size() - 1)) {
                int endInt = convertTimeToInt("23:59");
                countEnd = countTimeIndex(fstartInt, endInt);
                countEnd = countEnd + 1;
            }
            int zeroStartInt = convertTimeToInt("00:00");
            int zeroToEndInt = convertTimeToInt(finishTime);
            int countStart = countTimeIndex(zeroStartInt, zeroToEndInt);
            return countStart + countEnd;
        }
    }

    private int countTimeIndex(int startInt, int finishInt) {
        int startIndex = -1;
        int lenTime = timeList.size();
        int count = 0;
        for (int i = 0; i < lenTime; i++) {
            if (startInt <= timeList.get(i)) {
                startIndex = i;
                break;
            }
        }
        if (startIndex != -1) {
            for (int i = startIndex + 1; i < lenTime; i++) {
                if (timeList.get(i) <= finishInt) {
                    count++;
                }
            }
        }
        return count;
    }

    public int convertTimeToInt(String time) {
        String[] timeArr = time.split(":");
        return Integer.valueOf(timeArr[0]) * 60 + Integer.valueOf(timeArr[1]);
    }

    public static void main(String[] args) {
        Code5789 code5789 = new Code5789();
//        System.out.println(code5789.numberOfRounds("12:01", "12:44"));
//        System.out.println(code5789.numberOfRounds("20:00", "06:00"));
//        System.out.println(code5789.numberOfRounds("00:00", "23:59"));
//        System.out.println(code5789.numberOfRounds("00:01", "00:00"));
//        System.out.println(code5789.numberOfRounds("23:46", "00:15"));
//        System.out.println(code5789.numberOfRounds("23:37", "07:06"));
//        System.out.println(code5789.numberOfRounds("20:00", "06:00"));
//        System.out.println(code5789.numberOfRounds("00:01", "00:00"));
        System.out.println(code5789.numberOfRounds("23:45", "00:01"));
    }
}
