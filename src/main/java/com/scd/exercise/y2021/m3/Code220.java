package com.scd.exercise.y2021.m3;

/**
 * @author James
 */
public class Code220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            int otherIndex = i - k;
            if (otherIndex < 0) {
                otherIndex = 0;
            }
            while (otherIndex < lenn) {
                if (isRight(nums, t, lenn, i, otherIndex)) {
                    return true;
                }
                otherIndex++;
            }
            otherIndex = i + k;
            if (otherIndex > lenn - 1) {
                otherIndex = lenn - 1;
            }
            while (otherIndex >= 0) {
                if (isRight(nums, t, lenn, i, otherIndex)) {
                    return true;
                }
                otherIndex--;
            }
        }
        return false;
    }

    private boolean isRight(int[] nums, int t, int lenn, int i, int otherIndex) {
        if (i == otherIndex) {
            return false;
        }
        if (otherIndex >= 0 && otherIndex <= lenn - 1) {
            if (Math.abs(nums[i] - nums[otherIndex]) <= t) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code220 code220 = new Code220();
        System.out.println(code220.containsNearbyAlmostDuplicate(new int[]{1,2,1,1}, 1, 0));
    }
}
