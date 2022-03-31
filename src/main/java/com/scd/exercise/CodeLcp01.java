package com.scd.exercise;

import java.util.regex.Pattern;

/**
 * @author James
 */
public class CodeLcp01 {
    public int game(int[] guess, int[] answer) {
        int len = guess.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "HelloworldHello";
        str = str.replace("Hello", "");
        System.out.println(str);
    }
}
