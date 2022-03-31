package com.scd.exercise;

/**
 * @author James
 */
public class CodeOffer05 {

    public String replaceSpace(String s) {
        char[] charArr = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArr) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
