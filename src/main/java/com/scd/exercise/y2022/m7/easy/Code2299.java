package com.scd.exercise.y2022.m7.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2299. 强密码检验器 II
 * @author James
 */
public class Code2299 {
    private static final String spec_str = "!@#$%^&*()-+";

    private static final Set<Character> SPEC_CHAR_SET = new HashSet<>();

    static {
        int lens = spec_str.length();
        for (int i = 0; i < lens; i++) {
            SPEC_CHAR_SET.add(spec_str.charAt(i));
        }
    }


    public boolean strongPasswordCheckerII(String password) {
        int lenp = password.length();
        if (lenp < 8) {
            return false;
        }
        boolean[] charBool = new boolean[4];
        char temp = password.charAt(0);
        setBoolVal(charBool, temp);
        for (int i = 1; i < lenp; i++) {
            char curChar = password.charAt(i);
            if (temp == curChar) {
                return false;
            } else {
                temp = curChar;
            }
            setBoolVal(charBool, curChar);
        }
        for (boolean ch : charBool) {
            if (!ch) {
                return false;
            }
        }
        return true;
    }

    private void setBoolVal(boolean[] charBool, char temp) {
        if (Character.isLowerCase(temp)) {
            charBool[0] = true;
        }
        if (Character.isUpperCase(temp)) {
            charBool[1] = true;
        }
        if (Character.isDigit(temp)) {
            charBool[2] = true;
        }
        if (SPEC_CHAR_SET.contains(temp)) {
            charBool[3] = true;
        }
    }
}
