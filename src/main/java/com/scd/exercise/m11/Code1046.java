package com.scd.exercise.m11;

import java.util.Arrays;

/**
 * @author James
 */
public class Code1046 {

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        while (true) {
            int len = stones.length;
            if (len == 1 || len == 0) {
                break;
            }
            Arrays.sort(stones);
            int y = stones[len - 1];
            int x = stones[len - 2];
            int[] temp;
            if (x == y) {
                temp = new int[len - 2];
                System.arraycopy(stones, 0, temp, 0, temp.length);
            } else {
                temp = new int[len - 1];
                System.arraycopy(stones, 0, temp, 0, temp.length);
                temp[temp.length - 1] = y - x;
            }
            stones = temp;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        return 0;
    }

    public static void main(String[] args) {
        Code1046 code1046 = new Code1046();
        System.out.println(code1046.lastStoneWeight(new int[]{2,2}));
    }
}
