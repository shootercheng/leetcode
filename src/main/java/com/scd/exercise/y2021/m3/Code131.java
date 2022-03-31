package com.scd.exercise.y2021.m3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code131 {

    public List<List<String>> partition(String s) {
        int lens = s.length();
        for (int i = 0; i < lens; i++) {
            for (int j = i+1; j < lens + 1; j++) {
                String subStr = s.substring(i, j);
                System.out.println(subStr);
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Code131 code131 = new Code131();
        code131.partition("abcdefg");
    }
}
