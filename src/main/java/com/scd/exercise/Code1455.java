package com.scd.exercise;

/**
 * @author James
 */
public class Code1455 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] sArr = sentence.split("\\s+");
        int lenSarr = sArr.length;
        for (int i = 1; i <= lenSarr; i++) {
            String word = sArr[i - 1];
            if (word.startsWith(searchWord)) {
                return i;
            }
        }
        return -1;
    }
}
