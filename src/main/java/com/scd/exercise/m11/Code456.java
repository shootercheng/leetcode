package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code456 {

    public boolean find132pattern(int[] nums) {
        int lenn = nums.length;
        if (lenn <= 2) {
            return false;
        }
        for (int startIndex = 0; startIndex < lenn; startIndex++) {
            int i = -1;
            int j = -1;
            boolean isAsc = false;
            while (startIndex + 1 < lenn) {
                if (nums[startIndex] < nums[startIndex + 1]) {
                    isAsc = true;
                    i = startIndex;
                    j = startIndex + 1;
                    break;
                }
                startIndex++;
            }
            if (isAsc) {
                int k = j + 1;
                while (k < lenn) {
                    if (nums[k] > nums[i] && nums[k] < nums[j]) {
                        return true;
                    }
                    k++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums =  {3, 1, 4, 2};
        Code456 code456 = new Code456();
//        System.out.println(code456.find132pattern(nums));
//        System.out.println(code456.find132pattern(new int[]{1,0,1,-4,-3}));
        System.out.println(code456.find132pattern(new int[]{-2,1,2,-2,1,2}));
    }
}
