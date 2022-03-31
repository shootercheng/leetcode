package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class MCode1005 {

    public int findString(String[] words, String s) {
        int lenw = words.length;
        for (int i = 0; i < lenw; i++) {
            if (words[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
