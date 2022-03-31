package com.scd.contest.week237;

import java.util.Arrays;

/**
 * @author James
 */
public class Code5735 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        int sum = 0;
        for (int cost : costs) {
            sum = sum + cost;
            if (sum <= coins) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
