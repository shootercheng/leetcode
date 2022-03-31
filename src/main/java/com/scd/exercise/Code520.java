package com.scd.exercise;

/**
 * @author James
 */
public class Code520 {

    public boolean detectCapitalUse(String word) {
        char[] charArr = word.toCharArray();
        int len = charArr.length;
        if (len == 0) {
            return true;
        }
        char first = charArr[0];
        if (isUpper(first)) {
            return isAllUpper(charArr) || isAllLower(charArr, 1);
        } else {
            return isAllLower(charArr, 0);
        }
    }

    private boolean isUpper(char c) {
//        return c >= 'A' && c <= 'Z';
        return Character.isUpperCase(c);
    }

    private boolean isAllUpper(char[] chars) {
        for (char c : chars) {
            if (!isUpper(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllLower(char[] chars, int start) {
        int len = chars.length;
        for (int i = start; i <len; i++) {
            if (isUpper(chars[i])) {
                return false;
            }
        }
        return true;
    }
}
