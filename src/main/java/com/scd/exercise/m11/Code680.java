package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code680 {

    public boolean validPalindrome(String s) {
        if (isPalindrome(s)) {
            return true;
        }
        char[] inputArr = s.toCharArray();
        int leni = inputArr.length;
        for (int i = 0; i < leni; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < leni; j++) {
                if (j != i) {
                    builder.append(inputArr[j]);
                }
            }
            if (isPalindrome(builder.toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean isPalindrome(String input) {
        char[] inputArr = input.toCharArray();
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (inputArr[left] != inputArr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Code680 code680 = new Code680();
        System.out.println(code680.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
