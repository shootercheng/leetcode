package com.scd.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code771 {

    public int numJewelsInStones(String J, String S) {
        char[] jCharArr = J.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : jCharArr) {
            set.add(c);
        }
        char[] scharArr = S.toCharArray();
        int count = 0;
        for (char c : scharArr) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
