package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class MCode1701 {

    public int add(int a, int b) {
        int xor = a ^ b;
        int forward = (a & b) << 1;
        if (forward == 0) {
            return xor;
        } else {
            return add(xor, forward);
        }
    }

    public static void main(String[] args) {
        MCode1701 mCode1701 = new MCode1701();
        System.out.println(mCode1701.add(1, 3));
        int i = 1;
        int j = i << 1;
        System.out.println(Integer.toBinaryString(j));
    }
}
