package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1374 {

    public String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if (n % 2 == 0) {
            appendGenNumChar('a', n - 1, stringBuilder);
            appendGenNumChar('b', 1, stringBuilder);
        } else {
            appendGenNumChar('a', n, stringBuilder);
        }
        return stringBuilder.toString();
    }

    public void appendGenNumChar(char c, int n, StringBuilder builder) {
        for (int i = 0; i < n; i++) {
            builder.append(c);
        }
    }
}
