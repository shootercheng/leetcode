package com.scd.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code5661 {

    private static final int MIN_TIME = 0;

    private static final int MAX_TIME = 1439;

    private static final char[] RANDOM_CHAR = {'0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9'};

    public String maximumTime(String time) {
        StringBuilder timeBuilder = new StringBuilder();
        timeBuilder.append(time);
        char firstChar = timeBuilder.charAt(0);
        char secondChar = timeBuilder.charAt(1);
        if (firstChar == '?') {
            if (secondChar != '?') {
                int secondInt = Integer.parseInt(String.valueOf(secondChar));
                if (secondInt < 4) {
                    timeBuilder.setCharAt(0, '2');
                    firstChar = '2';
                } else {
                    timeBuilder.setCharAt(0, '1');
                    firstChar = '1';
                }
            } else {
                timeBuilder.setCharAt(0, '2');
                firstChar = '2';
            }
        }
        if (secondChar == '?') {
            if (firstChar != '2') {
                timeBuilder.setCharAt(1, '9');
            } else {
                timeBuilder.setCharAt(1, '3');
            }
        }
        char thridChar = timeBuilder.charAt(3);
        if (thridChar == '?') {
            timeBuilder.setCharAt(3, '5');
        }
        char fourthChar = timeBuilder.charAt(4);
        if (fourthChar == '?') {
            timeBuilder.setCharAt(4, '9');
        }
        return timeBuilder.toString();
    }

    private int calVal(StringBuilder input) {
        int index = input.indexOf(":");
        int hour = Integer.parseInt(input.substring(0, index));
        int minute = Integer.parseInt(input.substring(index + 1));
        if (minute >= 60) {
            return MAX_TIME + 1;
        }
        return hour * 60 + minute;
    }

    private int calVal(String input) {
        String[] timeArr = input.split(":");
        int hour = Integer.parseInt(timeArr[0]);
        int minute = Integer.parseInt(timeArr[1]);
        return hour * 60 + minute;
    }


    public static void main(String[] args) {
//        String input = "29:90";
//        String[] timeArr = input.split(":");
//        int hour = Integer.parseInt(timeArr[0]);
//        int minute = Integer.parseInt(timeArr[1]);
//        int value = hour * 60 + minute;
//        System.out.println(value);
        Code5661 code5661 = new Code5661();
        String[] inputArr = {
                "2?:?0",
                "0?:3?",
                "1?:22",
                "?4:03",
                "??:3?"
        };
        for (String time : inputArr) {
            System.out.println(code5661.maximumTime(time));
        }
        System.out.println(24 * 60);
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(input);
//        System.out.println(code5661.calVal(stringBuilder));
    }
}
