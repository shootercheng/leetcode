package com.scd.exercise.dp;

/**
 * @author James
 */
public class Code1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();
        int lentext1 = text1Arr.length;
        int lentext2 = text2Arr.length;
        if (lentext1 > lentext2) {
            return findLongSub(text1Arr, text2Arr);
        } else {
            return findLongSub(text2Arr, text1Arr);
        }
    }

    private int findLongSub(char[] s, char[] t) {
        int startIndex = 0;
//        int len
//        for (char c : t) {
//            startIndex = findCharIndex(s, c, )
//        }
        return startIndex;
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
