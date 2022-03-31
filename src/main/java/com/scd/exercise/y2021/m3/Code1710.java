package com.scd.exercise.y2021.m3;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author James
 */
public class Code1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(this::sort).reversed());
        int sum = 0;
        for (int[] box : boxTypes) {
            if (truckSize < box[0]) {
                sum = sum + truckSize * box[1];
                break;
            } else {
                sum = sum + box[0] * box[1];
            }
            truckSize = truckSize - box[0];
        }
        return sum;
    }

    private int sort(int[] n) {
        return n[1];
    }

    public static void main(String[] args) {
        Code1710 code1710 = new Code1710();
        int[][] array = new int[][]{
                {1,3},
                {2,2},
                {3,1}
        };
        System.out.println(code1710.maximumUnits(array, 4));
    }
}
