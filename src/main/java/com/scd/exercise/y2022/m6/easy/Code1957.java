package com.scd.exercise.y2022.m6.easy;

/**
 * 1957. 删除字符使字符串变好
 * @author James
 */
public class Code1957 {

    public String makeFancyString(String s) {
        int lens = s.length();
        if (s.length() == 0) {
            return "";
        }
        char temp = s.charAt(0);
        int count = 1;
        StringBuilder result = new StringBuilder();
        result.append(temp);
        for (int i = 1; i < lens; i++) {
            char curChar = s.charAt(i);
            if (curChar == temp) {
                count++;
            } else {
                temp = curChar;
                count = 1;
            }
            if (count <= 2) {
                result.append(curChar);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Code1957 code1957 = new Code1957();
        code1957.makeFancyString("leeetcode");
    }
}
