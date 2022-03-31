package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code41 {

    public int firstMissingPositive(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        boolean[] nexists = new boolean[max];
        for (int num : nums) {
            if (num >= 1) {
                nexists[num - 1] = true;
            }
        }
        for (int i = 0; i < max; i++) {
            if (!nexists[i]) {
                return i+1;
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        Code41 code41 = new Code41();
        code41.firstMissingPositive(new int[]{2147483647});
    }
}
