package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code392 {

    public boolean isSubsequence(String s, String t) {
        char[] scharArr = s.toCharArray();
        char[] tcharArr = t.toCharArray();
        int lens = scharArr.length;
        int startIndex = 0;
        for (int i = 0; i < lens; i++) {
            startIndex = findsCharIndex(tcharArr, startIndex, scharArr[i]);
            if (startIndex == -1) {
                return false;
            }
            startIndex = startIndex + 1;
        }
        return true;
    }

    public int findsCharIndex(char[] tcharArr, int startIndex, char t) {
        for (int i = startIndex; i < tcharArr.length; i++) {
            if (t == tcharArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "ace";
        String t = "abcde";
        Code392 code392 = new Code392();
        System.out.println(code392.isSubsequence(s, t));
    }
}
