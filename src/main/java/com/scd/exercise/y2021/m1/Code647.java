package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class Code647 {

    public int countSubstrings(String s) {
        int lens = s.length();
        int result = 0;
        for (int i = 0; i < lens; i++) {
            for (int j = i + 1; j <= lens; j++) {
                String subStr = s.substring(i, j);
                if (isRightPalindrom(subStr)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isRightPalindrom(String subStr) {
        int left = 0;
        int right = subStr.length() - 1;
        char[] subArr = subStr.toCharArray();
        while (left < right) {
            if (subArr[left] != subArr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Code647 code647 = new Code647();
        code647.countSubstrings("aaa");
    }
}
