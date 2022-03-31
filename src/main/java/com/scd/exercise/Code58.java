package com.scd.exercise;

/**
 * @author James
 */
public class Code58 {

    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int pointer = s.length() - 1;
        int len = 0;
        for (; pointer >= 0; pointer --) {
            char curChar = s.charAt(pointer);
            if (curChar != ' ') {
                len++;
            } else {
                break;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Code58 code58 = new Code58();
        String s = "123";
        System.out.println(code58.lengthOfLastWord(s));
    }
}
