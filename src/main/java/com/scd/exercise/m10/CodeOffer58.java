package com.scd.exercise.m10;

/**
 * @author James
 */
public class CodeOffer58 {

    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        String[] strArr = s.split("\\s+");
        int start = strArr.length - 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i >= 0; i--) {
            String trimStr = strArr[i].trim();
            if (trimStr.length() > 0) {
                stringBuilder.append(trimStr).append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        String wordStr = "  hello world!  ";
        CodeOffer58 codeOffer58 = new CodeOffer58();
        System.out.println(codeOffer58.reverseWords(wordStr));
    }
}
