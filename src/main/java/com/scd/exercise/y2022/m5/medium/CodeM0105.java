package com.scd.exercise.y2022.m5.medium;

/**
 * @author James
 */
public class CodeM0105 {

    public boolean oneEditAway(String first, String second) {
        int lenf = first.length();
        int lens = second.length();
        int abs = Math.abs(lenf - lens);
        if (abs > 1) {
            return false;
        }
        int count = 0;
        if (abs == 0) {
            for (int i = 0; i < lenf; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    count++;
                }
            }
        } else {
            if (lenf > lens) {
                count = countDiff(first, second);
            } else {
                count = countDiff(second, first);
            }
        }
        return count <= 1;
    }

    public int countDiff(String longs, String shorts) {
        int indexl = 0;
        int indexs = 0;
        int lensl = longs.length();
        int lenss = shorts.length();
        int count = 0;
        while (indexl < lensl && indexs < lenss) {
            char charL = longs.charAt(indexl);
            char charS = shorts.charAt(indexs);
            if (charL == charS) {
                indexl++;
                indexs++;
            } else {
                indexl++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CodeM0105 codeM0105 = new CodeM0105();
        System.out.println(codeM0105.countDiff("abcd", "bcd"));
        System.out.println(codeM0105.countDiff("abcd", "acd"));
        System.out.println(codeM0105.countDiff("abcd", "abc"));
        System.out.println(codeM0105.countDiff("abcd", "abcd"));
        System.out.println(codeM0105.countDiff("abcd", "ab"));
    }
}
