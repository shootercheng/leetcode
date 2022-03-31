package com.scd.exercise;

/**
 * @author James
 */
public class Code724 {

    public int pivotIndex(int[] nums) {
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            if (isLeftRightEq(i, nums, lenn)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isLeftRightEq(int i, int[] nums, int lenn) {
        int leftSum = 0;
        for (int j = 0; j < i; j++) {
            leftSum = leftSum + nums[j];
        }
        int rightSum = 0;
        for (int j = i + 1; j < lenn; j++) {
            rightSum = rightSum + nums[j];
        }
        if (leftSum == rightSum) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,0,1,1};
        Code724 code724 = new Code724();
        int result = code724.pivotIndex(nums);
        System.out.println(result);
    }
}
