package com.scd.exercise;

/**
 * @author James
 */
public class Code121 {

    public int maxProfit(int[] prices) {
        int max = 0;
        int len = prices.length;
        int inRes = 0;
        int outRes = 0;
        for (int i = 0; i < len - 1; i++) {
            int inIndex = i;
            int outIndex;
            for (int j = inIndex + 1; j < len; j++) {
                outIndex = j;
                int sub = prices[outIndex] - prices[inIndex];
                if (sub > max) {
                    max = sub;
                    inRes = inIndex;
                    outRes = outIndex;
                }
            }
        }
        System.out.println("in " + inRes + " out " + outRes + " max " + max);
        return max;
    }

    public static void main(String[] args) {
        int[] stock = {7,8,1,9};
        Code121 code121 = new Code121();
        code121.maxProfit(stock);
    }
}
