package com.scd.exercise.m10;

/**
 * @author James
 */
public class CodeOffer63 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            int profit = price - min;
            if (profit > max) {
                max = profit;
            }
        }
        return max;
    }
}
