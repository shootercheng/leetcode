package com.scd.exercise;

/**
 * @author James
 */
public class Code686 {

    public int repeatedStringMatch(String A, String B) {
        if (B.equals(A) || A.contains(B)) {
            return 1;
        }
        int alen = A.length();
        int blen = B.length();
        char[] acharArr = A.toCharArray();
        char[] bcharArr = B.toCharArray();
        int count = 0;
        for (int i = 0; i < blen; i++) {
            for (int j = 0; j < alen; j++) {
                if (acharArr[j] == bcharArr[i]) {
                    boolean isSame = isNextSame(acharArr, bcharArr, i, j, alen, blen);
                    if (isSame) {
                        // 下标右移动
                        i = i + alen - j - 1;
                        break;
                    } else {
                        return -1;
                    }
                }
            }
            count++;
        }
        return count;
    }

    private boolean isNextSame(char[] acharArr, char[] bcharArr, int i, int j, int alen, int blen) {
        for (int start = j; start < alen; start++) {
            // B 字符串结束
            if (i == blen) {
                return true;
            }
            if (acharArr[start] == bcharArr[i]) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        "abababaaba"
//        "aabaaba"
        String A = "abababaaba";
        String B = "aabaaba";
        Code686 code686 = new Code686();
        int count = code686.repeatedStringMatch(A, B);
        System.out.println(count);
    }
}
