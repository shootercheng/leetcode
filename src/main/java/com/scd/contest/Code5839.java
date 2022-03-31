package com.scd.contest;

import java.util.Arrays;

/**
 * @author James
 */
public class Code5839 {

    public int minStoneSum(int[] piles, int k) {
        Arrays.sort(piles);
        int sum = calSum(piles);
        int lenp = piles.length;
        int i = 1;
        int lastIndex = lenp - 1;
        while (i <= k) {
            int removed = piles[lastIndex] / 2;
            sum = sum - removed;
            int left = piles[lastIndex] - removed;
            piles[lastIndex] = left;
            resortArr(piles, lenp);
            i++;
        }
        return sum;
    }

    private int calSum(int[] piles) {
        int sum = 0;
        for (int pile : piles) {
            sum = sum + pile;
        }
        return sum;
    }

    private void resortArr(int[] piles, int lenp) {
        int last = piles[lenp - 1];
        int insertIndex = -1;
        for (int i = lenp - 1; i >= 0; i--) {
            if (last > piles[i]) {
                insertIndex = i + 1;
                break;
            }
        }
        if (insertIndex == -1) {
            insertIndex = 0;
        }
        for (int i = lenp - 1; i > insertIndex; i--) {
            piles[i] = piles[i - 1];
        }
        piles[insertIndex] = last;
    }

    public static void main(String[] args) {
        Code5839 code5839 = new Code5839();
        int[] pipArr = {5,4,9};
        int k = 2;
        System.out.println(code5839.minStoneSum(pipArr, 2));
    }
}
