package com.scd.exercise.y2021.m5;

/**
 * @author James
 */
public class Code1844 {

    public String replaceDigits(String s) {
        char[] sArr = s.toCharArray();
        int lens = sArr.length;
        for (int i = 0; i < lens; i = i + 2) {
            char c = sArr[i];
            if (i + 1 >= lens) {
                break;
            }
            char res = shift(c, Integer.valueOf(String.valueOf(sArr[i+1])));
            sArr[i+1] = res;
        }
        return new String(sArr);
    }

    public char shift(char c, int num) {
        return (char) (c + num);
    }
}
