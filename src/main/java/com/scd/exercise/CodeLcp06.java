package com.scd.exercise;

/**
 * @author James
 */
public class CodeLcp06 {
    public int minCount(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            int mod = coin % 2;
            if (mod == 0) {
                count = count + coin / 2;
            } else {
                count = count + coin / 2 + 1;
            }
        }
        return count;
    }
}
