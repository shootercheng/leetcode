package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1417 {

    public String reformat(String s) {
        char[] charArr = s.toCharArray();
        List<Character> numList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();
        for (char c : charArr) {
            if (c >= '0' && c <= '9') {
                numList.add(c);
            } else {
                charList.add(c);
            }
        }
        int numLen = numList.size();
        int charLen = charList.size();
        if (Math.abs(numLen - charLen) > 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (numLen > charLen) {
            for (int i = 0; i < charLen; i++) {
                stringBuilder.append(numList.get(i)).append(charList.get(i));
            }
            for (int i = charLen; i < numLen; i++) {
                stringBuilder.append(numList.get(i));
            }
        } else {
            for (int i = 0; i < numLen; i++) {
                stringBuilder.append(charList.get(i)).append(numList.get(i));
            }
            for (int i = numLen; i < charLen; i++) {
                stringBuilder.append(charList.get(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Code1417 code1417 = new Code1417();
        code1417.reformat("ab123");
    }
}
