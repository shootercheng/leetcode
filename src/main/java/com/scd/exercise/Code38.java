package com.scd.exercise;

/**
 * @author James
 */
public class Code38 {

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = nextNum(result);
        }
        return result;
    }

    private String nextNum(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArr = input.toCharArray();
        int len = charArr.length;
        char start = charArr[0];
        int count = 1;
        for (int i = 1; i < len; i++) {
            char curChar = charArr[i];
            if (start == curChar) {
                count++;
            } else {
                stringBuilder.append(count).append(start);
                count = 1;
                start = curChar;
            }
        }
        stringBuilder.append(count).append(start);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        // f(1) = 1
        // f(2) = 11
//        String inputArr = "21";
        Code38 code38 = new Code38();
//        System.out.println(code38.nextNum("1"));
        System.out.println(code38.countAndSay(1));
        System.out.println(code38.countAndSay(2));
        System.out.println(code38.countAndSay(3));
        System.out.println(code38.countAndSay(4));
        System.out.println(code38.countAndSay(5));
    }
}
