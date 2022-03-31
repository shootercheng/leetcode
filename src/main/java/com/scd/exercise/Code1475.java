package com.scd.exercise;

/**
 * @author James
 */
public class Code1475 {

    public int[] finalPrices(int[] prices) {
        int lenp = prices.length;
        int[] result = new int[lenp];
        for (int i = 0; i < lenp; i++) {
            int j = findNextLess(prices, i, lenp);
            if (j != -1) {
                result[i] = prices[i] - prices[j];
            } else {
                result[i] = prices[i];
            }
        }
        return result;
    }

    private int findNextLess(int[] prices, int i, int len) {
        for (int j = i + 1; j < len; j++) {
            if (prices[j] <= prices[i]) {
                return j;
            }
        }
        return -1;
    }
}
