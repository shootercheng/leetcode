package com.scd.contest;

/**
 * @author James
 */
public class Code5614 {

    public int[] mostCompetitive(int[] nums, int k) {
        int[] result = new int[k];
        int i = 0;
        int startIndex = 0;
        while (k > 0) {
            int endIndex = nums.length - k;
            int curIndex = findMin(startIndex, endIndex, nums);
            if (curIndex != -1) {
                result[i] = nums[curIndex];
            }
            startIndex = curIndex + 1;
            i++;
            k--;
        }
        return result;
    }

    public int findMin(int startIndex, int endIndex, int[] nums) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = startIndex; i <= endIndex; i++) {
            if (nums[i] < min) {
                min = nums[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,2,6};
        Code5614 code5614 = new Code5614();
        System.out.println(code5614.mostCompetitive(nums, 2));
    }
}
