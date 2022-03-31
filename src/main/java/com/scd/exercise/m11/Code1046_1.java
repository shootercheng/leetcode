package com.scd.exercise.m11;

import java.util.Arrays;

/**
 * @author James
 */
public class Code1046_1 {

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        int endPointer = stones.length - 1;
        while (endPointer != 0 && endPointer != -1) {
            Arrays.sort(stones, 0, endPointer + 1);
            int y = stones[endPointer];
            int x = stones[endPointer - 1];
            if (x == y) {
                endPointer = endPointer - 2;
            } else {
                endPointer = endPointer - 1;
                stones[endPointer] = y - x;
            }
        }
        if (endPointer == 0) {
            return stones[0];
        }
        return 0;
    }

    public static void main(String[] args) {
        Code1046_1 code1046 = new Code1046_1();
        System.out.println(code1046.lastStoneWeight(new int[]{2,2}));
        System.out.println(code1046.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
