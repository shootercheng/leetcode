package com.scd.exercise.y2022.m5;

/**
 * @author James
 */
public class Code2210 {

    public int countHillValley(int[] nums) {
        int lenn = nums.length;
        int count = 0;
        int temp = nums[0];
        for (int i = 1; i < lenn; i++) {
            int curNum = nums[i];
            if (temp == curNum) {
                continue;
            } else {
                temp = curNum;
            }
            int previous = findPrevious(i, nums);
            int next = findNext(i, nums);
            if (previous != -1 && next != -1) {
                if (curNum > previous && curNum > next) {
                    count++;
                } else if (curNum < previous && curNum < next) {
                    count++;
                }
            }
        }
        return count;
    }

    private int findPrevious(int startIndex, int[] nums) {
        int curNum = nums[startIndex];
        for (int i = startIndex; i >= 0; i--) {
            if (nums[i] != curNum) {
                return nums[i];
            }
        }
        return -1;
    }

    private int findNext(int startIndex, int[] nums) {
        int curNum = nums[startIndex];
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] != curNum) {
                return nums[i];
            }
        }
        return -1;
    }
}
