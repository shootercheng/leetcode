package com.scd.contest.week258;

/**
 * @author James
 */
public class Code5867 {

    public String reversePrefix(String word, char ch) {
        char[] wcharArr = word.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int lenw = wcharArr.length;
        int startIndex = -1;
        for (int i = 0; i < lenw; i++) {
            stringBuilder.append(wcharArr[i]);
            if (wcharArr[i] == ch) {
                startIndex = i;
                break;
            }
        }
        if (startIndex != -1) {
            return stringBuilder.reverse() + word.substring(startIndex + 1);
        }
        return word;
    }
}
