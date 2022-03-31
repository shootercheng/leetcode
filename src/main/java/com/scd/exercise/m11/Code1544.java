package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1544 {

    public String makeGood(String s) {
        char[] scharArr = s.toCharArray();
        int lens = scharArr.length;
        boolean[] scharUsed = new boolean[lens];
        int i = 0;
        while (i < lens) {
            int preIndex = findNotUsedCharIndex(i, scharUsed, lens);
            int nextIndex = findNotUsedCharIndex(preIndex+1, scharUsed, lens);
            if (preIndex == -1 || nextIndex == -1) {
                break;
            }
            if (Math.abs(scharArr[preIndex] - scharArr[nextIndex]) == 32) {
                scharUsed[preIndex] = true;
                scharUsed[nextIndex] = true;
                i = 0;
            } else {
                i++;
            }
        }
        StringBuilder result = new StringBuilder("");
        for (int j = 0; j < lens; j++) {
            if (!scharUsed[j]) {
                result.append(scharArr[j]);
            }
        }
        return result.toString();
    }

    private int findNotUsedCharIndex(int startIndex, boolean[] used, int lens) {
        for (int i = startIndex; i < lens; i++) {
            if (!used[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        Code1544 code1544 = new Code1544();
//        System.out.println(code1544.makeGood(s));
        String s1 = "abBAcC";
        System.out.println(code1544.makeGood(s1));
    }
}
