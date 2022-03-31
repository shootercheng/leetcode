package com.scd.study.operator;

/**
 * @author James
 */
public class Xor {

    public static void testSwap() {
        int a = 1;
        int b = 2;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a="+a + ",b="+b);
    }

    public static void main(String[] args) {
        int a = 1 ^ 1;
        int b = 2 ^ 0;
        System.out.println(a == 0);
        System.out.println(b == 2);
        testSwap();
    }
}
