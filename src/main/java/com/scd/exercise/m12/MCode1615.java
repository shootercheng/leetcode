package com.scd.exercise.m12;

/**
 * @author James
 */
public class MCode1615 {

    public int[] masterMind(String solution, String guess) {
        int[] result = new int[2];
        int lens = solution.length();
        char[] sArr = solution.toCharArray();
        char[] gArr = guess.toCharArray();
        boolean[] sused = new boolean[lens];
        boolean[] gused = new boolean[lens];
        for (int i = 0; i < lens; i++) {
            if (sArr[i] == gArr[i]) {
                result[0]++;
                sused[i] = true;
                gused[i] = true;
            }
        }
        for (int i = 0; i < lens; i++) {
            for (int j = 0; j < lens; j++) {
                if (sused[i]) {
                    break;
                }
                if (!gused[j] && sArr[i] == gArr[j]) {
                    result[1]++;
                    sused[i] = true;
                    gused[j] = true;
                }
            }
        }
        return result;
    }
}
