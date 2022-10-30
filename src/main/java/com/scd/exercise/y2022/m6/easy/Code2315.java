package com.scd.exercise.y2022.m6.easy;

/**
 * 2315. 统计星号
 * @author James
 */
public class Code2315 {

    public int countAsterisks(String s) {
        int startIndex = 0;
        int lens = s.length();
        boolean lineMark = false;
        int count = 0;
        while (startIndex < lens) {
            char curChar = s.charAt(startIndex);
            if (curChar == '|') {
                lineMark = !lineMark;
            } else {
                if (!lineMark && curChar == '*') {
                    count++;
                }
            }
            startIndex++;
        }
        return count;
    }

    public static void main(String[] args) {
        Code2315 code2315 = new Code2315();
        code2315.countAsterisks("|**e|23**233");
    }
}
