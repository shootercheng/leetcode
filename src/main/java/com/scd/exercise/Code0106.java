package com.scd.exercise;

/**
 * @author James
 */
public class Code0106 {

    public String compressString(String s) {
        int slen = s.length();
        StringBuilder stringBuilder = new StringBuilder(slen);
        char[] schars = s.toCharArray();
        int count = 1;
        char previous = schars[0];
        for (int i = 1; i < slen; i++) {
            char curChar = schars[i];
            if (curChar == previous) {
                count++;
            } else {
                stringBuilder.append(previous).append(count);
                previous = curChar;
                count = 1;
            }
        }
        stringBuilder.append(previous).append(count);
        if (stringBuilder.length() < slen) {
            return stringBuilder.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        Code0106 code0106 = new Code0106();
        System.out.println(code0106.compressString("abaaaaaa"));
    }
}
