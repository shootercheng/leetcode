package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1592 {

    public String reorderSpaces(String text) {
        if (text == null) {
            return null;
        }
        if (text.trim().length() == 0) {
            return text;
        }
        char[] tArr = text.toCharArray();
        int lent = tArr.length;
        int space = 0;
        StringBuilder word = new StringBuilder();
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < lent; i++) {
            if (Character.isLetter(tArr[i])) {
                word.append(tArr[i]);
            } else {
                if (word.length() > 0) {
                    wordList.add(word.toString());
                    word.setLength(0);
                }
                space++;
            }
        }
        if (word.length() > 0) {
            wordList.add(word.toString());
        }
        int wSize = wordList.size();
        if (wSize == 1) {
            StringBuilder spaceBuilder = createSpace(space);
            return wordList.get(0) + spaceBuilder.toString();
        }
        int avg = space / (wSize - 1);
        int mod = space % (wSize - 1);
        StringBuilder result = new StringBuilder();
        StringBuilder tempSpace = createSpace(avg);
        for (int i = 0; i < wSize - 1; i++) {
            result.append(wordList.get(i)).append(tempSpace);
        }
        result.append(wordList.get(wSize - 1));
        StringBuilder modSpace = createSpace(mod);
        return result.append(modSpace).toString();
    }

    private StringBuilder createSpace(int n) {
        StringBuilder tempSpace = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            tempSpace.append(" ");
        }
        return tempSpace;
    }

    public static void main(String[] args) {
        String text = " makes   ";
        Code1592 code1592 = new Code1592();
        System.out.println(code1592.reorderSpaces(text));
    }
}
