package com.scd.exercise;

/**
 * @author James
 */
public class Code1486 {
    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; i++) {
            int temp = start + 2 * i;
            result = result ^ temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Code1486 code1486 = new Code1486();
        System.out.println(code1486.xorOperation(1, 7));
    }
}
