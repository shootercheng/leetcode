package com.scd.contest.week250;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code5161 {

    public int canBeTypedWords(String text, String brokenLetters) {
        String[] textArr = text.split("\\s+");
        int count = 0;
        for (String word : textArr) {
            char[] wchars = word.toCharArray();
            boolean isBroken = false;
            for (char c : wchars) {
                String sctr = String.valueOf(c);
                if (brokenLetters.contains(sctr)) {
                    isBroken = true;
                    break;
                }
            }
            if (!isBroken) {
                count++;
            }
        }
        return count;
    }
}
