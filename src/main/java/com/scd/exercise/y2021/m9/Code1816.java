package com.scd.exercise.y2021.m9;

/**
 * @author James
 */
public class Code1816 {

    public String truncateSentence(String s, int k) {
        char[] scharArr = s.toCharArray();
        int count = 0;
        int lens = s.length();
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < lens; i++) {
            if (scharArr[i] == ' ') {
                while (scharArr[i] == ' ' && i < lens) {
                    builder.append(scharArr[i]);
                    i++;
                }
                count++;
            }
            if (count == k) {
                break;
            }
            builder.append(scharArr[i]);
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        Code1816 code1816 = new Code1816();
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(code1816.truncateSentence(s, k));
    }
}
