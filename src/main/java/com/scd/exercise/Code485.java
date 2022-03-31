package com.scd.exercise;

/**
 * @author James
 */
public class Code485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }
        if (count > max) {
            max = count;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        Code485 code485 = new Code485();
        System.out.println(code485.findMaxConsecutiveOnes(nums));
    }
}
