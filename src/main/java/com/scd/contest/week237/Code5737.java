package com.scd.contest.week237;

import java.util.Arrays;

/**
 * @author James
 */
public class Code5737 {

    public int getXORSum(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length * arr2.length];
        int index = 0;
        for (int i : arr1) {
            for (int j : arr2) {
                arr[index++] = i & j;
            }
        }
        Arrays.sort(arr);
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(2 ^ 2);
        System.out.println(1 & 6);
        System.out.println(1 & 5);
        System.out.println(0 ^ 5);
        System.out.println(0 ^ 10);
    }
}
