package com.scd.exercise.y2022.m4.easy;

/**
 * @author James
 */
public class CodeOffer018 {

    public boolean isPalindrome(String s) {
        char[] sArr = s.toCharArray();
        int lens = sArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lens; i++) {
            if (Character.isLetter(sArr[i]) || Character.isDigit(sArr[i])) {
                stringBuilder.append(sArr[i]);
            }
        }
        int left = 0;
        int right = stringBuilder.length() - 1;
        while (left < right) {
            char leftChar = stringBuilder.charAt(left);
            char rightChar = stringBuilder.charAt(right);
            if (Character.isLetter(leftChar) && Character.isLetter(rightChar)) {
                boolean isPalind = (leftChar == rightChar)
                        || (Math.abs(leftChar - rightChar) == 32);
                if (!isPalind) {
                    return false;
                }
            } else if (Character.isDigit(leftChar) && Character.isDigit(rightChar)) {
                if (leftChar != rightChar) {
                    return false;
                }
            } else {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        CodeOffer018 codeOffer018 = new CodeOffer018();
        codeOffer018.isPalindrome(" ");
    }
}
