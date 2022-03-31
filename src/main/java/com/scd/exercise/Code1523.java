package com.scd.exercise;

/**
 * @author James
 */
public class Code1523 {

    public int countOdds(int low, int high) {
        int count = 0;
        if (low % 2 == 0) {
            low = low + 1;
            count++;
        }
        for (int i = low; i <= high; i = i + 2) {
                count++;
        }
        return count;
    }
}
