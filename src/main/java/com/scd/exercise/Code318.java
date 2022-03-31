package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code318 {

    public int maxProduct(String[] words) {
        int maxLen = 0;
        int lenw = words.length;
        List<char[]> list = new ArrayList<>();
        for (int i = 0; i < lenw; i++) {
            char[] wchars = words[i].toCharArray();
            list.add(wchars);
        }
        for (int i = 0; i < lenw; i++) {
            for (int j = 0; j < lenw; j++) {
                if (i != j) {
                    int len = calLen(list, i, j);
                    if (len != 0 && len > maxLen) {
                        maxLen = len;
                    }
                }
            }
        }
        return maxLen;
    }

    private int calLen(List<char[]> list, int i, int j) {
        char[] iwords = list.get(i);
        char[] jwords = list.get(j);
        for (char ci : iwords) {
            for (char cj : jwords) {
                if (ci == cj) {
                    return 0;
                }
            }
        }
        return iwords.length * jwords.length;
    }
}
