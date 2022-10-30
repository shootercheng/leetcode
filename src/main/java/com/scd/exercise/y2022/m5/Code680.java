package com.scd.exercise.y2022.m5;

/**
 * @author James
 */
public class Code680 {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                boolean moveLeft = tryMove(left+1, right, s);
                if (!moveLeft) {
                    return tryMove(left, right - 1, s);
                } else {
                    return true;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean tryMove(int left, int right, String s) {
        if (left >= s.length() || right < 0) {
            return false;
        }
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Code680 code680 = new Code680();
        code680.validPalindrome("abcba");
        code680.validPalindrome("abcddcba");
    }
}
