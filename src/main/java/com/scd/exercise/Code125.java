package com.scd.exercise;

/**
 * @author James
 */
public class Code125 {

    public boolean isPalindrome(String s) {
        char[] charArr = s.toCharArray();
        int len = charArr.length;
        int leftIndex = 0;
        int rightIndex = len - 1;
        while (leftIndex < rightIndex) {
            char leftChar;
            while (true) {
                leftChar = charArr[leftIndex];
                if (!isLetterOrNum(leftChar)) {
                    leftIndex++;
                } else {
                    break;
                }
                if (leftIndex == len) {
                    break;
                }
            }
            char rightChar;
            while (true) {
                rightChar = charArr[rightIndex];
                if (!isLetterOrNum(rightChar)) {
                    rightIndex--;
                } else {
                    break;
                }
                if (rightIndex == -1) {
                    break;
                }
            }
            if (isLetterOrNum(leftChar) && isLetterOrNum(rightChar) && !isSame(leftChar, rightChar)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    private boolean isLetterOrNum(char c) {
        return isLetter(c) || isNumber(c);
    }

    private boolean isLetter(char c) {
        boolean upper = c >= 'A' && c <= 'Z';
        boolean lower = c >= 'a' && c <= 'z';
        if (upper || lower) {
            return true;
        }
        return false;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isSame(char left, char right) {
        if (left == right) {
            return true;
        }
        if (isLetter(left)) {
            if (left + 32 == right || left - 32 == right) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "0P";
        Code125 code125 = new Code125();
        System.out.println(code125.isPalindrome(s));
    }
}
