package com.scd.exercise;

import java.util.Arrays;

/**
 * @author James
 */
public class Code242 {

    public boolean isAnagram(String s, String t) {
        char[] scharArr = s.toCharArray();
        char[] tcharArr = t.toCharArray();
        int slen = scharArr.length;
        int tlen = tcharArr.length;
        if (slen != tlen) {
            return false;
        }
        Arrays.sort(scharArr);
        Arrays.sort(tcharArr);
        for (int i = 0; i < slen; i++) {
            if (scharArr[i] != tcharArr[i]) {
                return false;
            }
        }
        return true;
    }
}
