package com.scd.exercise;

/**
 * @author James
 */
public class Code1342 {

    public int numberOfSteps(int num) {
        int step = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        Code1342 code1342 = new Code1342();
        System.out.println(code1342.numberOfSteps(123));
    }
}
