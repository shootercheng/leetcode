package com.scd.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code0101 {

    public boolean isUnique(String astr) {
        Set<Character> characterSet = new HashSet<>();
        char[] chars = astr.toCharArray();
        for (char c : chars) {
            if (!characterSet.contains(c)) {
                characterSet.add(c);
            } else {
                return false;
            }
        }
        return true;
    }
}
