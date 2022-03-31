package com.scd.exercise;

/**
 * @author James
 */
public class Code434 {

    public int countSegments(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        String[] words = s.split("\\s+");
        return words.length;
    }
}
