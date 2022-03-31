package com.scd.exercise.m11;

/**
 * @author James
 */
public class MCode1607 {

    public int maximum(int a, int b) {
        int average = (a + b) / 2;
        return average + Math.abs(average - a);
    }
}
