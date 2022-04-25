package com.scd.exercise.y2022.m4.easy;

import com.scd.exercise.Code189;

import java.util.Set;

/**
 * @author James
 */
public class Code1893 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] record = new int[right + 1];
        for (int[] range : ranges) {
            for (int index = range[0]; index <= range[range.length - 1]; index++) {
                if (index <= right && index >= 0) {
                    record[index] = 1;
                }
            }
        }
        for (int i = left; i <= right; i++) {
            if (record[i] != 1) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] ranges = new int[][]{{1,50}};
        Code1893 code1893 = new Code1893();
        code1893.isCovered(ranges, 1, 50);
    }
}
