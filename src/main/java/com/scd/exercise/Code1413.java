package com.scd.exercise;

/**
 * @author James
 */
public class Code1413 {

    public int minStartValue(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int lenn = nums.length;
        if (lenn == 0) {
            return -1;
        }
        int min = 1 - nums[0];
        if (min <= 0) {
            min = 1;
        }
        while (min < Integer.MAX_VALUE) {
            int sum = min;
            for (int i = 0; i < lenn; i++) {
                sum = sum + nums[i];
                if (sum < 1) {
                    break;
                }
                if (i == lenn - 1) {
                    return min;
                }
            }
            min++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Code1413 code1413 = new Code1413();
        int[] num1 = {-3,2,-3,4,2};
        System.out.println(code1413.minStartValue(num1));
    }
}
