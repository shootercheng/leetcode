package com.scd.exercise;

import jdk.internal.org.objectweb.asm.Handle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code535 {

    private static final Map<Character, Character> CHAR_MAP = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder result = new StringBuilder();
        char[] encryptArr = longUrl.toCharArray();
        for (char c : encryptArr) {
            if (Character.isLetter(c)) {
                if (c == 'z') {
                    result.append('a');
                } else if (c == 'Z') {
                    result.append('A');
                } else {
                    c = (char) (c + 1);
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) throws IOException {
        char[] strresChar = shortUrl.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : strresChar) {
            if (Character.isLetter(c)) {
                if (c == 'a') {
                    stringBuilder.append('z');
                } else if (c == 'A') {
                    stringBuilder.append('Z');
                } else {
                    c = (char) (c - 1);
                    stringBuilder.append(c);
                }
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String url = "https://qsdqweqwe.wewe/wewq";
    }
}
