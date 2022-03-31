package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code209 {

    public int minSubArrayLen(int s, int[] nums) {
        int lenn = nums.length;
        int startIndex = 0;
        int endIndex = 1;
        int minLen = Integer.MAX_VALUE;
        while (startIndex < lenn) {
            int sum = nums[startIndex];
            if (sum == s) {
                return 1;
            }
            while (endIndex < lenn) {
                sum = sum + nums[endIndex];
                if (sum > s) {
                    break;
                }
                if (sum == s) {
                    int temp = endIndex - startIndex;
                    if (temp < minLen) {
                        minLen = temp;
                    }
                    break;
                }
                endIndex++;
            }
            startIndex++;
            endIndex = startIndex + 1;
        }
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }
        return minLen + 1;
    }

    public static void main(String[] args) {
        Code209 code209 = new Code209();
        System.out.println(code209.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
