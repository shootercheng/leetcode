package com.scd.exercise.m12;

/**
 * @author James
 */
public class MCode0805 {

    public int multiply(int A, int B) {
        if (A > B) {
            return sumMultiply(A, B);
        } else {
            return sumMultiply(B, A);
        }
    }

    public int sumMultiply(int a, int b) {
        if (b == 1) {
            return a;
        }
        b--;
        return a + sumMultiply(a, b);
    }

    public static void main(String[] args) {
        MCode0805 code0805 = new MCode0805();
        System.out.println(code0805.multiply(10, 1));
        System.out.println(code0805.multiply(10, 2));
    }
}
