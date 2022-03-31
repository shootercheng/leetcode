package com.scd.exercise;

/**
 * @author James
 */
public class Code258 {

    public int addDigits(int num) {
        String numStr = String.valueOf(num);
        char[] charArr = numStr.toCharArray();
        int sum;
        while (true) {
            sum = 0;
            for (char c : charArr) {
                int i = c - 48;
                sum = sum + i;
            }
            if (sum <= 9) {
                break;
            }
            charArr = String.valueOf(sum).toCharArray();
        }
        return sum;
    }

    public static void main(String[] args) {
        Code258 code258 = new Code258();
        System.out.println(code258.addDigits(38));
    }
}
