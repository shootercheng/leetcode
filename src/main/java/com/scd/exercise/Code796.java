package com.scd.exercise;

/**
 * @author James
 */
public class Code796 {

    public boolean rotateString(String A, String B) {
        if (A == null || B == null) {
            return false;
        }
        char[] acharArr = A.toCharArray();
        char[] bcharArr = B.toCharArray();
        int alen = acharArr.length;
        int blen = bcharArr.length;
        if (alen == 0 && blen == 0) {
            return true;
        }
        if (alen != blen) {
            return false;
        }
        int end = alen - 1;
        for (int j = 0; j < alen - 1; j++) {
            char temp = acharArr[0];
            for (int i = 0; i < end; i++) {
                acharArr[i] = acharArr[i + 1];
            }
            acharArr[end] = temp;
            if (isSame(acharArr, bcharArr, alen)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSame(char[] acharArr, char[] bcharArr, int alen) {
        for (int i = 0; i < alen; i++) {
            if (acharArr[i] != bcharArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Code796 code796 = new Code796();
        String a = "abcde";
        code796.rotateString(a, "");
    }
}
