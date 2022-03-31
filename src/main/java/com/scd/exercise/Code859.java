package com.scd.exercise;

/**
 * @author James
 */
public class Code859 {

    public boolean buddyStrings(String A, String B) {
        char[] acharArr = A.toCharArray();
        char[] bcharArr = B.toCharArray();
        int alen = acharArr.length;
        int blen = bcharArr.length;
        char[] acharTemp = new char[alen];
        System.arraycopy(acharArr, 0, acharTemp, 0, alen);
        if (alen != blen) {
            return false;
        }
        boolean find = false;
        for (int i = 0; i < alen; i++) {
            for (int j = 1; j < alen; j++) {
                if (i != j) {
                    char temp = acharTemp[i];
                    acharTemp[i] = acharTemp[j];
                    acharTemp[j] = temp;
                    if (isSame(acharTemp, bcharArr, alen)) {
                        find = true;
                    } else {
                        System.arraycopy(acharArr, 0, acharTemp, 0, alen);
                    }
                }

            }
        }
        if (find) {
            return true;
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
        String a = "aaaaaaabc";
        String b = "aaaaaaacb";
        Code859 code859 = new Code859();
        System.out.println(code859.buddyStrings(a, b));
    }
}
