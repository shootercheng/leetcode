package com.scd.exercise;

/**
 * @author James
 */
public class Code8 {

    public static void main(String[] args) {
        Code8 code8 = new Code8();
        System.out.println(code8.strToInt("-44"));
        System.out.println(code8.strToInt("4193 with words"));
        System.out.println(code8.strToInt("words and 987"));
        System.out.println(code8.strToInt("-91283472332"));
    }

    public int strToInt(String s) {
        int result = 0;
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        char firstChar = s.charAt(0);
        if (isLetter(firstChar)) {
            return 0;
        } else if (firstChar == '-') {
            s = s.substring(1);
            result = convertStrToNegative(s);
        } else {
            result = convertStrNonNegative(s);
        }
        return result;
    }

    private static boolean isLetter(char c) {
        return ( c >= 'A' && c <= 'Z') || ( c >= 'a' && c <= 'z');
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private static int convertStrToNegative(String inputStr) {
        char[] charArr = inputStr.toCharArray();
        int result = 0;
        int multmin = Integer.MIN_VALUE / 10;
        int len = charArr.length;
        for (int i= 0; i < len; i++) {
            char curChar = charArr[i];
            if (!isNumber(curChar)) {
                break;
            }
            int digit = (int) curChar - 48;
            if (result < multmin) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 - digit;
            if (result > 0) {
                return Integer.MIN_VALUE;
            }
        }
        return result;
    }


    private static int convertStrNonNegative(String inputStr) {
        char[] charArr = inputStr.toCharArray();
        int result = 0;
        int multmin = Integer.MAX_VALUE / 10;
        int len = charArr.length;
        for (int i = 0; i < len; i++) {
            char curChar = charArr[i];
            if (!isNumber(curChar)) {
                break;
            }
            int digit = (int) curChar - 48;
            if (result > multmin) {
                return Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            if (result < 0) {
                return Integer.MAX_VALUE;
            }
        }
        return result;
    }
}
