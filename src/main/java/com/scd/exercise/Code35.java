package com.scd.exercise;

/**
 * @author James
 */
public class Code35 {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int index = len;
        for (int i = 0; i < len; i++) {
            int curNum = nums[i];
            if (curNum == target) {
                return i;
            } else {
                if (curNum > target) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Code35 code35 = new Code35();
        System.out.println(code35.searchInsert(nums, 0));
        System.out.println(code35.searchInsert(nums, 6));
    }
}
