package com.scd.contest;

/**
 * @author James
 */
public class Code5615 {

    public int minMoves(int[] nums, int limit) {
        int k = 0;
        int lenn = nums.length;
        while (k < limit) {
            if (isRight(nums)) {
                return k;
            }
            int[] temp = new int[lenn];
            System.arraycopy(nums, 0, temp, 0, lenn);
            for (int i = 0, j = lenn - 1; i < lenn; i++, j--) {
                nums[i] = nums[i] + temp[j];
            }
            k++;
        }
        return k;
    }

    private boolean isRight(int[] nums) {
        int lenn = nums.length;
        int start = nums[0];
        for (int i = 1; i < lenn; i++) {
            int next = nums[i];
            if (start != next) {
                return false;
            }
            start = next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,3};
        Code5615 code5615 = new Code5615();
        System.out.println(code5615.minMoves(nums, 4));
    }
}
