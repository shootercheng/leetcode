package com.scd.exercise;

/**
 * @author James
 */
public class CodeOffer58 {

    public String reverseLeftWords(String s, int n) {
        String left = s.substring(0, n);
        String sub = s.substring(n);
        return sub + left;
    }
}
