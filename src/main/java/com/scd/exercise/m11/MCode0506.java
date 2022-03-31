package com.scd.exercise.m11;

/**
 * @author James
 */
public class MCode0506 {

    public int convertInteger(int A, int B) {
        String strA = Integer.toBinaryString(A);
        String strB = Integer.toBinaryString(B);
        int lena = strA.length();
        int lenb = strB.length();
        if (lena < lenb) {
            strA = appendZero(lenb - lena) + strA;
        } else {
            strB = appendZero(lena - lenb) + strB;
        }
        char[] acharArr = strA.toCharArray();
        char[] bcharArr = strB.toCharArray();
        int len = acharArr.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (acharArr[i] != bcharArr[i]) {
                count++;
            }
        }
        return count;
    }

    public String appendZero(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append("0");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int a = 2147483647;
    }
}
