package com.scd.exercise.y2022.m6.easy;

/**
 * @author James
 */
public class Code1108 {

    public String defangIPaddr(String address) {
        int lena = address.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lena; i++) {
            char curChar = address.charAt(i);
            if (curChar == '.') {
                result.append("[.]");
            } else {
                result.append(curChar);
            }
        }
        return result.toString();
    }
}
