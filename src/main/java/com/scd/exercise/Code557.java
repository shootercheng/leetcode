package com.scd.exercise;

/**
 * @author James
 */
public class Code557 {

    public String reverseWords(String s) {
        String[] sArr = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String input : sArr) {
            stringBuilder.append(new StringBuilder(input).reverse()).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
