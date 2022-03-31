package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class Code405 {

    public String toHex(int num) {
        return Integer.toHexString(num);
    }

    public static void main(String[] args) {
        Code405 code405 = new Code405();
        System.out.println(code405.toHex(-1));
    }
}
