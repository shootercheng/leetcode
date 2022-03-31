package com.scd.exercise;

/**
 * @author James
 */
public class Code739 {

    public int[] dailyTemperatures(int[] T) {
        int lent = T.length;
        int[] result = new int[lent];
        for (int i = 0; i < lent - 1; i++) {
            for (int j = i+1; j < lent; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
