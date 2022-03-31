package com.scd.contest;

/**
 * @author James
 */
public class Code5617 {

    public String interpret(String command) {
        char[] cArr = command.toCharArray();
        int lenc = cArr.length;
        StringBuilder result = new StringBuilder();
        int startIndex = 0;
        while (startIndex < lenc){
            char c = cArr[startIndex];
            if (c == '(') {
                if (cArr[++startIndex] == ')') {
                    result.append("o");
                } else {
                    startIndex = startIndex + 2;
                    result.append("al");
                }
            } else {
                result.append(c);
            }
            startIndex++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Code5617 code5617 = new Code5617();
        System.out.println(code5617.interpret("G()(al)"));
        System.out.println(code5617.interpret("G()()()()(al)"));
    }
}
