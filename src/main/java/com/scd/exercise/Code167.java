package com.scd.exercise;

/**
 * @author James
 */
public class Code167 {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int max = len;
        for (int i = 0; i < len; i++) {
            if (numbers[i] > target) {
                max = i;
                break;
            }
        }
        int[] result = new int[2];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (numbers[i] + numbers[j] == target && i < j) {
                    result[0] = i+1;
                    result[1] = j+1;
                    break;
                }
            }
        }
        return result;
    }
}
