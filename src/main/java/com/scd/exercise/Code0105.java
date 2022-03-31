package com.scd.exercise;

/**
 * @author James
 */
public class Code0105 {

    public boolean oneEditAway(String first, String second) {
        int firstLen = first.length();
        int secondLen = second.length();
        char[] firstChar = first.toCharArray();
        char[] secondChar = second.toCharArray();
        if (firstLen == secondLen) {
            int notSame = 0;
            for (int i = 0; i < firstLen; i++) {
                if (firstChar[i] != secondChar[i]) {
                    notSame++;
                }
            }
            if (notSame < 2) {
                return true;
            } else {
                return false;
            }
        } else if (firstLen == secondLen + 1) {
            int diff = findDiffIndex(firstChar, secondChar, secondLen);
            if (diff == -1) {
                return true;
            }
            // aaale
            // aale
            String firstSub = first.substring(diff + 1);
            String secondSub = second.substring(diff);
            if (firstSub.equals(secondSub)) {
                return true;
            } else {
                return false;
            }
        } else if (firstLen == secondLen - 1) {
            int diff = findDiffIndex(firstChar, secondChar, firstLen);
            if (diff == -1) {
                return true;
            }
            // aaale
            // aaaale
            // aaalef -> diff == -1
            String firstSub = first.substring(diff);
            String secondSub = second.substring(diff + 1);
            if (firstSub.equals(secondSub)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private int findDiffIndex(char[] firstChar, char[] secondChar, int len) {
        for (int i = 0; i < len; i++) {
            if (firstChar[i] != secondChar[i]) {
                return i;
            }
        }
        return -1;
    }
}
