package com.scd.exercise;

/**
 * @author James
 */
public class CodeLcp17 {

    public int calculate(String s) {
        int x = 1;
        int y = 0;
        char[] scharArr = s.toCharArray();
        for (char c : scharArr) {
            if (c == 'A') {
                x = 2 * x + y;
            } else if (c == 'B') {
                y = 2 * y + x;
            }
        }
        return x+y;
    }

    public static void main(String[] args) {
        CodeLcp17 codeLcp17 = new CodeLcp17();
        int res = codeLcp17.calculate("AB");
        System.out.println(res);
    }
}
