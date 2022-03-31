package com.scd.exercise.y2022.m3;

/**
 * 1876. 长度为三且各字符不同的子字符串
 * @author James
 */
public class Code1876 {

    public int countGoodSubstrings(String s) {
        int startIndex = 0;
        int loop = s.length() - 3;
        int result = 0;
        while (startIndex <= loop) {
            char x = s.charAt(startIndex);
            char y = s.charAt(startIndex + 1);
            char z = s.charAt(startIndex + 2);
            if (x != y && y != z && x != z) {
                result++;
            }
            startIndex++;
        }
        return result;
    }

    public static void main(String[] args) {
        Code1876 code1876 = new Code1876();
        code1876.countGoodSubstrings("xyzzaz");
    }
}
