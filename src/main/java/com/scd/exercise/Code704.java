package com.scd.exercise;

/**
 * @author James
 */
public class Code704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            } else if (midNum < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        Code704 code704 = new Code704();
        System.out.println(code704.search(nums, -1));
        System.out.println(code704.search(nums, 3));
        System.out.println(code704.search(nums, 12));
    }
}
