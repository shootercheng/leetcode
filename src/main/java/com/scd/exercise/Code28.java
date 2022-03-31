package com.scd.exercise;

/**
 * @author James
 */
public class Code28 {

    public int findIndex(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0) {
            return 0;
        }
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

    }
}
