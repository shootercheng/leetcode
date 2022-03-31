package com.scd.contest;

/**
 * @author James
 */
public class Code5605 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder builder1 = getStr(word1);
        StringBuilder builder2 = getStr(word2);
        int lenb1 = builder1.length();
        int lenb2 = builder2.length();
        if (lenb1 != lenb2) {
            return false;
        }
        for (int i = 0; i < lenb1; i++) {
            if (builder1.charAt(i) != builder2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private StringBuilder getStr(String[] word1) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : word1) {
            stringBuilder.append(s);
        }
        return stringBuilder;
    }
}
