package com.scd.contest.week275;

import java.util.Arrays;

/**
 * @author James
 */
public class Code5978 {

    public int wordCount(String[] startWords, String[] targetWords) {
        Arrays.sort(startWords, this::sortLen);
        Arrays.sort(targetWords, this::sortLen);
        int s = 0;
        int lens = startWords.length;
        int t = 0;
        int lent = targetWords.length;
        int count = 0;
        int maxLen = startWords[lens - 1].length();
        sortArr(startWords, lens);
        sortArr(targetWords, lent);
        while (t < lent) {
            if (targetWords[t].length() > maxLen + 1) {
                break;
            }
            int resIndex = findIndex(t, targetWords[t], s, startWords);
            if (resIndex != -1) {
                count++;
            }
            t++;
        }
        return count;
    }

    private void sortArr(String[] startWords, int lens) {
        for (int i = 0; i < lens; i++) {
            char[] charArr = startWords[i].toCharArray();
            Arrays.sort(charArr);
            startWords[i] = new String(charArr);
        }
    }

    private int findIndex(int t, String targetWord, int s, String[] startWords) {
        int resultIndex = -1;
        for (int i = s; i < startWords.length; i++) {
            String curWord = startWords[i];
            if (curWord.length() + 1 == targetWord.length()) {
                int diffCount = 0;
                int indext = 0;
                int indexs = 0;
                while (indext < targetWord.length() && indexs < curWord.length()) {
                    if (curWord.charAt(indexs) == targetWord.charAt(indext)) {
                        indexs++;
                        indext++;
                    } else {
                        indext++;
                        diffCount++;
                    }
                    if (diffCount > 1) {
                        break;
                    }
                }
                if (diffCount <= 1) {
                    resultIndex = i;
                    break;
                }
            }
        }
        return resultIndex;
    }

    private int sortLen(String o1, String o2) {
        return o1.length() - o2.length();
    }

    public static void main(String[] args) {
//        String[] startWords = {"ant","act","tack"};
//        String[] targetWords = {"tack","act","acti"};
//        String[] startWords = {"ab","a"};
//        String[] targetWords = {"abc","abcd"};
        String[] startWords = {"mox","bj","rsy","jqsh"};
        String[] targetWords = {"trk","vjb","jkr"};
        Code5978 code5978 = new Code5978();
        code5978.wordCount(startWords, targetWords);
    }
}
