package com.scd.contest;

/**
 * @author James
 */
public class Code5629 {

    public String reformatNumber(String number) {
        char[] numArr = number.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : numArr) {
            if (c == ' ' || c == '-') {
                continue;
            }
            builder.append(c);
        }
        int startIndex = 0;
        int lens = builder.length();
        StringBuilder result = new StringBuilder();
        while (startIndex < lens - 4) {
            String subStr = builder.substring(startIndex, startIndex+3);
            result.append(subStr).append("-");
            startIndex = startIndex + 3;
        }
        if (lens - startIndex == 4) {
            String subStr = builder.substring(startIndex, startIndex + 2);
            result.append(subStr).append("-");
            String lastStr = builder.substring(startIndex+2);
            result.append(lastStr);
        } else {
            String subStr = builder.substring(startIndex);
            result.append(subStr);
        }
        return result.toString();

    }

    public static void main(String[] args) {
        Code5629 code5629 = new Code5629();
//        System.out.println(code5629.reformatNumber("1-23-45 6"));
//        System.out.println(code5629.reformatNumber("123 4-567"));
//        System.out.println(code5629.reformatNumber("123 4-5678"));
        System.out.println(code5629.reformatNumber("123"));
    }
}
