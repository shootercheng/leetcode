package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code11 {

    public int maxArea(int[] height) {
        int lenh = height.length;
        if (lenh <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lenh; i++) {
            for (int j = i+1; j < lenh; j++) {
                int curVol = calVal(i, j, height);
                if (curVol > max) {
                    max = curVol;
                }
            }
        }
        return max;
    }

    private int calVal(int startIndex, int endIndex, int[] height) {
        int minHeight = Math.min(height[startIndex], height[endIndex]);
        return minHeight * (endIndex - startIndex);
    }

    public static void main(String[] args) {
        Code11 code11 = new Code11();
        System.out.println(code11.maxArea(new int[]{1,2,3,4,5,6}));
    }
}
