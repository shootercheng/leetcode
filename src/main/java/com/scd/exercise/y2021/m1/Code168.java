package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class Code168 {

    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 26) {
            int mod = n % 26;
            char curChar;
            if (mod != 0) {
                curChar = (char) ('A' + mod - 1);
            } else {
                curChar = 'Z';
            }
            result.append(curChar);
            n = n / 26;
            if (mod == 0) {
                n = n -1;
            }
        }
        char curChar = (char) ('A' + n - 1);
        result.append(curChar);
        return result.reverse().toString();
    }

    public String convertToTitle2(int n) {
        StringBuilder result = new StringBuilder();
        while (n >= 26) {
            int mod = n % 26;
            char curChar;
            if (mod != 0) {
                curChar = (char) ('A' + mod);
            } else {
                curChar = 'Z';
            }
            result.append(curChar);
            n = n / 26;
            if (mod == 0) {
                n = n -1;
            }
        }
        char curChar = (char) ('A' + n);
        result.append(curChar);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Code168 code168 = new Code168();
        System.out.println(code168.convertToTitle(52));
        System.out.println(code168.convertToTitle2(52));
    }
}
