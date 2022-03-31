package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class Code1221_1 {

    public int balancedStringSplit(String s) {
        char[] scharArr = s.toCharArray();
        int lens = scharArr.length;
        char temp = scharArr[0];
        int count = 1;
        int result = 0;
        for (int i = 1; i < lens - 1; i++) {
            char curChar = scharArr[i];
            if (curChar == temp) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    result++;
                    i++;
                    temp = scharArr[i];
                    count = 1;
                }
            }
        }
        return result + 1;
    }

    public static void main(String[] args) {
        Code1221_1 code1221 = new Code1221_1();
        System.out.println(code1221.balancedStringSplit("RLLLLRRRLR"));
    }
}
