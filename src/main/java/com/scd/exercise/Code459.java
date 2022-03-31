package com.scd.exercise;

/**
 * @author James
 */
public class Code459 {

    public boolean repeatedSubstringPattern(String s) {
        int lens = s.length();
        if (lens < 2) {
            return false;
        }
        int center;
        if (lens % 2 == 0) {
            center = lens / 2;
        } else {
            center = lens / 2 + 1;
        }
        for (int i = 1; i <= center; i++) {
            String temp = s;
            String subStr = temp.substring(0, i);
            int lenSub = subStr.length();
            int loop = lens / lenSub + 1;
            for (int j = 0; j < loop; j++) {
                if (temp.length() < lenSub) {
                    break;
                }
                String tsub = temp.substring(0, lenSub);
                if (!subStr.equals(tsub)) {
                    break;
                }
                temp = temp.substring(lenSub);
                if (temp.length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code459 code459 = new Code459();
        System.out.println(code459.repeatedSubstringPattern("a"));
        System.out.println(code459.repeatedSubstringPattern("abab"));
    }
}
