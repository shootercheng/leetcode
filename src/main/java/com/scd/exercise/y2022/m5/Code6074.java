package com.scd.exercise.y2022.m5;

/**
 * @author James
 */
public class Code6074 {

    public int percentageLetter(String s, char letter) {
        int lens = s.length();
        int count = 0;
        for (int i = 0; i < lens; i++) {
            char curChar = s.charAt(i);
            if (curChar == letter) {
                count++;
            }
        }
        double result = (double) count / lens * 100;
        return (int) result;
    }

    public static void main(String[] args) {
        Code6074 code6074 = new Code6074();
        code6074.percentageLetter("foobar", 'o');
    }
}
