package com.scd.exercise;

/**
 * @author James
 */
public class Code598_1 {

    public int maxCount(int m, int n, int[][] ops) {
        int tempm = m;
        int tempn = n;
        for (int[] opArr : ops) {
            if (opArr[0] < tempm) {
                tempm = opArr[0];
            }
            if (opArr[1] < tempn) {
                tempn = opArr[1];
            }
        }
        return tempm * tempn;
    }
}
